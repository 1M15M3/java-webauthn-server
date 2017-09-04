package com.yubico.webauthn.data

import java.util.Optional


case class MakePublicKeyCredentialOptions(

  /**
    * Contains data about the Relying Party responsible for the request.
    */
  rp: PublicKeyCredentialEntity,

  /**
    * Contains data about the user account for which the Relying Party is
    * requesting attestation.
    */
  user: PublicKeyCredentialUserEntity,

  /**
    * A challenge intended to be used for generating the newly created
    * credential’s attestation object.
    */
  challenge: ArrayBuffer,

  /**
    * Information about the desired properties of the credential to be created.
    *
    * The sequence is ordered from most preferred to least preferred. The
    * client will make a best-effort to create the most preferred credential
    * that it can.
    */
  pubKeyCredParams: Vector[PublicKeyCredentialParameters],

  /**
    * A time, in milliseconds, that the caller is willing to wait for the call
    * to complete.
    *
    * This is treated as a hint, and may be overridden by the client.
    */
  timeout: Optional[Long],

  /**
    * Intended for use by Relying Parties that wish to limit the creation of
    * multiple credentials for the same account on a single authenticator. The
    * client is requested to return an error if the new credential would be
    * created on an authenticator that also contains one of the credentials
    * enumerated in this parameter.
    */
  excludeCredentials: Optional[Vector[PublicKeyCredentialDescriptor]],

  /**
    * Intended for use by Relying Parties that wish to select the appropriate
    * authenticators to participate in the create() or get() operation.
    */
  authenticatorSelection: Optional[AuthenticatorSelectionCriteria],

  /**
    * Additional parameters requesting additional processing by the client and
    * authenticator.
    *
    * For example, the caller may request that only authenticators with certain
    * capabilies be used to create the credential, or that particular
    * information be returned in the attestation object. Some extensions are
    * defined in §8 WebAuthn Extensions; consult the IANA "WebAuthn Extension
    * Identifier" registry  for an up-to-date list of registered WebAuthn
    * Extensions.
    */
  extensions: Optional[AuthenticationExtensions],
)