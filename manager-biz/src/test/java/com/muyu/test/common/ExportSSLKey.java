package com.muyu.test.common;



    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileWriter;
    import java.security.Key;
    import java.security.KeyPair;
    import java.security.KeyStore;
    import java.security.KeyStoreException;
    import java.security.NoSuchAlgorithmException;
    import java.security.PrivateKey;
    import java.security.PublicKey;
    import java.security.UnrecoverableKeyException;
    import java.security.cert.Certificate;


    import sun.misc.BASE64Encoder;

/**
 * Created by maowei on 2015/11/13.
 */
public class ExportSSLKey {
        private File keystoreFile;
        private String keyStoreType;
        private char[] password;
        private String alias;
        private File exportedFile;

        public static KeyPair getPrivateKey(KeyStore keystore, String alias, char[] password) {
            try {
                Key key=keystore.getKey(alias,password);
                if(key instanceof PrivateKey) {
                    Certificate cert=keystore.getCertificate(alias);
                    PublicKey publicKey=cert.getPublicKey();
                    return new KeyPair(publicKey,(PrivateKey)key);
                }
            } catch (UnrecoverableKeyException e) {
            } catch (NoSuchAlgorithmException e) {
            } catch (KeyStoreException e) {
            }
            return null;
        }



        public void export() throws Exception{
            KeyStore keystore=KeyStore.getInstance(keyStoreType);
            BASE64Encoder encoder=new BASE64Encoder();
            keystore.load(new FileInputStream(keystoreFile),password);
            KeyPair keyPair=getPrivateKey(keystore,alias,password);
            PrivateKey privateKey=keyPair.getPrivate();
            String encoded=encoder.encode(privateKey.getEncoded());
            FileWriter fw=new FileWriter(exportedFile);
            fw.write("—–BEGIN PRIVATE KEY—–/n");
            fw.write(encoded);
            fw.write("/n");
            fw.write("—–END PRIVATE KEY—–");
            fw.close();

        }


        public static void main(String args[]) throws Exception{
            String file = "D:/tools/nginx-1.5.1/server.keystore";
            String type = "pfx";
            String password = "changeit";
            String alias = "tomcat";
            String fileExpt = "D:/tools/nginx-1.5.1/server6.pfx";
            ExportSSLKey export=new ExportSSLKey();
            export.keystoreFile=new File(file);
            export.keyStoreType=type;
            export.password=password.toCharArray();
            export.alias=alias;
            export.exportedFile=new File(fileExpt);
            export.export();

//
//            ExportPrivateKey export=new ExportPrivateKey();
//            export.keystoreFile=new File("/Users/Luke/Workspace/StringTest/src/com/lukejin/stringtest/keystore.jks");
//            export.keyStoreType="JKS";
//            export.password="changeit".toCharArray();
//            export.alias="tom_server";
//            export.exportedFile=new File("luke");
//            export.export();
        }
    }

