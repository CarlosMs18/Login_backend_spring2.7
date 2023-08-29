package proyecto.springbootlogin.auth;

public class JwtConfig { //15 creacion de meoto para generar llave secreta MAC
    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

    public static final String RSA_PRIVADA = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDjfR8yRYr7Nu/J\n" +
            "iXTqUN6ecNcZty6Hqkp3DjFjuaklZXZZr3p37huZa/jUeuKDCspUC0dGwHSlR5+T\n" +
            "CdTz1XH1WI86yf4RNt7QUhLa8SU/Wd/gZTSKwS9Loh3/Z9/fiqs9soHIcpo5XhUF\n" +
            "QCJR4MKsFAWDApI6dMHYYmFCZNDxSbi+Dd1G8jsGakub8fhUfPheuoZL6dswFuxP\n" +
            "UwMAzx/thau0tLYE+PF8i1KgAzRZ15y5N1Rv4MdCdS7iCn1uE/4a02lzrrcLeebk\n" +
            "ZbzdQ8TFA4R1UECtNBiWnv7+jTlH6s8f/VFGV37OrPzH6A5zW1y/QzlXAHj4whZS\n" +
            "yNKJddw/AgMBAAECggEAMEAvOD342wzNcl1F35c0iL2dWhZ494x+i98GScUs48Iw\n" +
            "BpjKLJrj3rhAiGziE3Jb9NSJky+p7g6RgaIBuZApwiS9CHakfWk6fEwUNL0WLeg1\n" +
            "rIY6zT1pdyzVGQGiwerLJGRy052/KXDTm4/9V4mJMO90NdP7SQvPu8IuJ+NzT+Hx\n" +
            "GkwjmEvQmAY18utqTBA1tCy79b6MYGoHwjflqjEyCsg5OM0dLo4UeUeaDYIElnfE\n" +
            "8JghfcPwvjvMHOWaMB4CRFtJ/qg/7gXMyljp0qy2Or7KMU4OoYJeUpRJLSQVVtfZ\n" +
            "ChJX/sr4Q4Rn7K3CtJIpP60KAMoqsXno63SjzawUgQKBgQD+YHUk1fIR/fDV9MAc\n" +
            "TxX7sBsXv2CYsIbIrJH81fQY1XSTtZKN6bP+j51QSZUJ6wf3aQ9ZHaNEBVjZ+oK0\n" +
            "d6ELM801lCnL2I/+KrRGHS9lnaAfPKMp/vYDETyYUz45EXT/t/EmHyfI3R605cvD\n" +
            "NCvgaHfk7wEqTzVdo4RZAvXDvwKBgQDk8L2jd1G2Bj2NBXjL1VNb9mlujv6gZWKz\n" +
            "xybL4JDJO6lCxyZkjlAi8K9xGi3abBQxrYI2WS9CDyRfksE76kNHk0O1JkMYoKwk\n" +
            "qy+3PANy141LWCU/uIc4MPXuh6F/lVRzXvYKL1Fkxct4lZrDTG3y7TKGG0n8polj\n" +
            "0srBLbwHgQKBgF9ABx1P72DFUdUL3JO9GWIxQzPVOXpzP0UNOW0PQGO8KfbVWpdB\n" +
            "F2EOrb1OkDwygb0m3dRkwKnLxsV4hFDHKspjD0gsvqnR4bkujGpkq0bFixunPQGQ\n" +
            "stXbMnFnWjlMTB8k5Wt85wzTn5flJDNn6bYR6DMVO754AmeZvwkFjrlJAoGBALlu\n" +
            "bItsZ5iBcXU5i1+9x6ji6v6Lf522wL1QfxH/MAZt9miKGYS06B+ExvVa+OzDQZAD\n" +
            "M0aF8gsVbKaknTLESf49P0gIV6wo54VDyoAlcb2g7WarXHBCK/PNZETxQlOuRhq0\n" +
            "PaB+NvTiaC2hLxskWqG6kYOhssmasglSgLr7KiMBAoGBAM/QQQbXPPNILOzEJBei\n" +
            "p6dthxPrIeHs/5TvUbCVkQ4/nsYt/l5Ue8Ca7guS6sm7r2uvkZpFTgRrj7lUToDk\n" +
            "xpbhsX1NJppaA/ugAlokpgG7rziO3RauDJEY+LLpyeN1jt1HJg/R0kDXdZQTXtnz\n" +
            "8exsG8p0EFbEtFeSFdNb46WE\n" +
            "-----END PRIVATE KEY-----";



    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA430fMkWK+zbvyYl06lDe\n" +
            "nnDXGbcuh6pKdw4xY7mpJWV2Wa96d+4bmWv41HrigwrKVAtHRsB0pUefkwnU89Vx\n" +
            "9ViPOsn+ETbe0FIS2vElP1nf4GU0isEvS6Id/2ff34qrPbKByHKaOV4VBUAiUeDC\n" +
            "rBQFgwKSOnTB2GJhQmTQ8Um4vg3dRvI7BmpLm/H4VHz4XrqGS+nbMBbsT1MDAM8f\n" +
            "7YWrtLS2BPjxfItSoAM0WdecuTdUb+DHQnUu4gp9bhP+GtNpc663C3nm5GW83UPE\n" +
            "xQOEdVBArTQYlp7+/o05R+rPH/1RRld+zqz8x+gOc1tcv0M5VwB4+MIWUsjSiXXc\n" +
            "PwIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
