package org.osate.assure.util;

import com.google.inject.ImplementedBy;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.util.DefaultVerificationMethodDispatcher;

@ImplementedBy(DefaultVerificationMethodDispatcher.class)
@SuppressWarnings("all")
public interface IVerificationMethodDispatcher {
  public abstract void dispatchVerificationMethod(final String methodPath, final InstanceObject target);
  
  public abstract void runVerificationMethod(final VerificationActivityResult verificationActivityResult);
}
