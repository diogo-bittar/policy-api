package br.com.diogo.policyapi.dto;

public record PolicyResponse(Long id, String insuredName, double premiumValue, String category) {

}
