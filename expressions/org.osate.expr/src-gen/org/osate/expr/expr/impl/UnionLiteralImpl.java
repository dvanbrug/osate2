/**
 */
package org.osate.expr.expr.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.expr.expr.ExprPackage;
import org.osate.expr.expr.FieldValue;
import org.osate.expr.expr.UnionLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Union Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.impl.UnionLiteralImpl#getFieldValue <em>Field Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnionLiteralImpl extends LiteralImpl implements UnionLiteral
{
  /**
   * The cached value of the '{@link #getFieldValue() <em>Field Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldValue()
   * @generated
   * @ordered
   */
  protected FieldValue fieldValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnionLiteralImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ExprPackage.Literals.UNION_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FieldValue getFieldValue()
  {
    return fieldValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFieldValue(FieldValue newFieldValue, NotificationChain msgs)
  {
    FieldValue oldFieldValue = fieldValue;
    fieldValue = newFieldValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExprPackage.UNION_LITERAL__FIELD_VALUE, oldFieldValue, newFieldValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFieldValue(FieldValue newFieldValue)
  {
    if (newFieldValue != fieldValue)
    {
      NotificationChain msgs = null;
      if (fieldValue != null)
        msgs = ((InternalEObject)fieldValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExprPackage.UNION_LITERAL__FIELD_VALUE, null, msgs);
      if (newFieldValue != null)
        msgs = ((InternalEObject)newFieldValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExprPackage.UNION_LITERAL__FIELD_VALUE, null, msgs);
      msgs = basicSetFieldValue(newFieldValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExprPackage.UNION_LITERAL__FIELD_VALUE, newFieldValue, newFieldValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ExprPackage.UNION_LITERAL__FIELD_VALUE:
        return basicSetFieldValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ExprPackage.UNION_LITERAL__FIELD_VALUE:
        return getFieldValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ExprPackage.UNION_LITERAL__FIELD_VALUE:
        setFieldValue((FieldValue)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ExprPackage.UNION_LITERAL__FIELD_VALUE:
        setFieldValue((FieldValue)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ExprPackage.UNION_LITERAL__FIELD_VALUE:
        return fieldValue != null;
    }
    return super.eIsSet(featureID);
  }

} //UnionLiteralImpl