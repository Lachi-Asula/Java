package Enc_Dec;

public class Decrypt {

    //JavaScript code

//    function hex2a(hexx) {
//        var hex = hexx.toString();
//        var str = '';
//        for (var i = 0; i < hex.length; i += 2)
//            str += String.fromCharCode(parseInt(hex.substr(i, 2), 16));
//        return str;
//    }
//
//    function decrypt(encryptedString, password) {
//        MFP.Logger.info("decryptParams(encryptedString, Password)" + JSON.stringify(encryptedString) + " & " + JSON.stringify(password));
//        var start = new Date();
//        var words = CryptoJS.enc.Base64.parse(encryptedString);
//        var textString = CryptoJS.enc.Utf8.stringify(words);
//        var decryptedString = CryptoJS.AES.decrypt(textString, password);
//        decryptedString = hex2a(decryptedString);
//        if(printDecryptLog == null || printDecryptLog == 'undefined' || printDecryptLog == '' || printDecryptLog == 'true' ){
//            MFP.Logger.info("decrypt decryptedString: " + JSON.stringify(decryptedString));
//        }
//        var end = new Date();
//        var timetaken = (end - start) / 1000;
//        MFP.Logger.info("decryptParams Exit timetaken: " + timetaken.toString());
//        var encryptesValue = JSON.parse(decryptedString);
//        return {"decryptedString" : encryptesValue};
//    }


}

//Note:
//        -----
//        password is like secret key or AccessValue
//        Ex: 646f04fe-f818-4a03-a321-124e5b9c9700