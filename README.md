SHA-512
=======

Improved SHA-512 hashing algorithm that generates a random 20 byte salt to add in with the string to be hashed. This is then hashed providing greater security.

Due to the random generation of the salt each time a string is hashed, this makes it pretty much impossible to get the same hash for a string, therefore once the salt has been generated the first time round it is stored in sharedPreferences for future uses so that you can use it for checking matches etc 

Method of converting the bytes to hex string shamelessly kanged from [maybeWeCouldStealAVan](http://stackoverflow.com/users/1284661/maybewecouldstealavan) @ [stackoverflow](http://stackoverflow.com/questions/9655181/convert-from-byte-array-to-hex-string-in-java/9855338#9855338).


#Example:

    
    String example = "example";
    try {
        example = Crypto.SHA512(example, context);
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }


All credits go to [Jonny from xda-developers](http://forum.xda-developers.com/showpost.php?p=53188724&postcount=1)
