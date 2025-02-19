package com.nowjobs.blinkid.recognizers.serialization;

import com.microblink.entities.recognizers.Recognizer;
import com.nowjobs.blinkid.recognizers.RecognizerSerialization;

import org.json.JSONException;
import org.json.JSONObject;

public final class IdBarcodeRecognizerSerialization implements RecognizerSerialization {

    @Override
    public Recognizer<?> createRecognizer(JSONObject jsonRecognizer) {
        com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer recognizer = new com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer();
        return recognizer;
    }

    @Override
    public JSONObject serializeResult(Recognizer<?> recognizer) {
        com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer.Result result = ((com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer)recognizer).getResult();
        JSONObject jsonResult = new JSONObject();
        try {
            SerializationUtils.addCommonResultData(jsonResult, result);
            jsonResult.put("additionalAddressInformation", result.getAdditionalAddressInformation());
            jsonResult.put("additionalNameInformation", result.getAdditionalNameInformation());
            jsonResult.put("address", result.getAddress());
            jsonResult.put("barcodeType", SerializationUtils.serializeEnum(result.getBarcodeType()));
            jsonResult.put("dateOfBirth", SerializationUtils.serializeDate(result.getDateOfBirth()));
            jsonResult.put("dateOfExpiry", SerializationUtils.serializeDate(result.getDateOfExpiry()));
            jsonResult.put("dateOfIssue", SerializationUtils.serializeDate(result.getDateOfIssue()));
            jsonResult.put("documentAdditionalNumber", result.getDocumentAdditionalNumber());
            jsonResult.put("documentNumber", result.getDocumentNumber());
            jsonResult.put("documentType", SerializationUtils.serializeEnum(result.getDocumentType()));
            jsonResult.put("employer", result.getEmployer());
            jsonResult.put("firstName", result.getFirstName());
            jsonResult.put("fullName", result.getFullName());
            jsonResult.put("issuingAuthority", result.getIssuingAuthority());
            jsonResult.put("lastName", result.getLastName());
            jsonResult.put("maritalStatus", result.getMaritalStatus());
            jsonResult.put("nationality", result.getNationality());
            jsonResult.put("personalIdNumber", result.getPersonalIdNumber());
            jsonResult.put("placeOfBirth", result.getPlaceOfBirth());
            jsonResult.put("profession", result.getProfession());
            jsonResult.put("race", result.getRace());
            jsonResult.put("rawData", SerializationUtils.encodeByteArrayToBase64(result.getRawData()));
            jsonResult.put("religion", result.getReligion());
            jsonResult.put("residentialStatus", result.getResidentialStatus());
            jsonResult.put("sex", result.getSex());
            jsonResult.put("stringData", result.getStringData());
            jsonResult.put("uncertain", result.isUncertain());
        } catch (JSONException e) {
            // see https://developer.android.com/reference/org/json/JSONException
            throw new RuntimeException(e);
        }
        return jsonResult;
    }

    @Override
    public String getJsonName() {
        return "IdBarcodeRecognizer";
    }

    @Override
    public int getDocumentId() {
        return -4;
    }

    @Override
    public Class<?> getRecognizerClass() {
        return com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer.class;
    }
}