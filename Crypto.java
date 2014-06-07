public class Crypto {
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    protected static String SHA512(String string, Context context) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        String salt = getSalt(context);
        md.update(salt.getBytes());
        byte[] bytes = md.digest(string.getBytes());
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static String getSalt(Context context) throws NoSuchAlgorithmException {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String salt = preferences.getString("salt", null);
        if (salt == null) {
            byte[] saltBytes = new byte[20];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(saltBytes);
            salt = new String(saltBytes);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("salt", salt).commit();
        }
        return salt;
    }
}
