package gaia3d.security;

public class JWTEncryptionHMAC {
	
	private final String HMAC_SHA_512 = "HmacSHA512";

	public boolean verify(String privateKey, String secretKey, String receivedValue) {
//		try {
//			SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(),	HMAC_SHA_512);
//			Mac mac = Mac.getInstance(HMAC_SHA_512);
//			mac.init(signingKey);
//			
//			
//			byte[] rawHmac = mac.doFinal(data.getBytes());
//			String result = new String(Base64.encodeBase64(rawHmac));
//			return result;
//			
//			
//			digest.init(secretKey);
//			digest.update(apiKey.getBytes(StandardCharsets.UTF_8));
//			digest.update(rawPayload.getBytes(StandardCharsets.UTF_8));
//			final byte[] expectedDigest = digest.doFinal();
//			digest.reset();
//
//			final byte[] receivedDigestBytes = DatatypeConverter.parseHexBinary(receivedDigest);
//			if (!MessageDigest.isEqual(receivedDigestBytes, expectedDigest)) {
//			    // invalid digest
//			}
//		} catch (GeneralSecurityException e) {
//			LOG.warn("Unexpected error while creating hash: " + e.getMessage(),	e);
//			throw new IllegalArgumentException();
//		}
		return true;
	}
}
