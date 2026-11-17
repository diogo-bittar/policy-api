package br.com.diogo.policyapi.dto;

public record PolicyRequest(String insuredName, double premiumValue, String category) {
}
