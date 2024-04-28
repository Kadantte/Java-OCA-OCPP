/*
   ChargeTime.eu - Java-OCA-OCPP

   MIT License

   Permission is hereby granted, free of charge, to any person obtaining a copy
   of this software and associated documentation files (the "Software"), to deal
   in the Software without restriction, including without limitation the rights
   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
   copies of the Software, and to permit persons to whom the Software is
   furnished to do so, subject to the following conditions:

   The above copyright notice and this permission notice shall be included in all
   copies or substantial portions of the Software.

   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
   SOFTWARE.
*/

package eu.chargetime.ocpp.v201.model.types;

import eu.chargetime.ocpp.PropertyConstraintException;
import eu.chargetime.ocpp.utilities.MoreObjects;
import java.util.Objects;
import javax.annotation.Nullable;

/** A physical or logical component */
public final class Component {
  /** Custom data */
  @Nullable private CustomData customData;

  /**
   * EVSE
   *
   * <p>Electric Vehicle Supply Equipment
   */
  @Nullable private EVSE evse;

  /**
   * Name of the component. Name should be taken from the list of standardized component names
   * whenever possible. Case Insensitive. strongly advised to use Camel Case.
   */
  private String name;

  /**
   * Name of instance in case the component exists as multiple instances. Case Insensitive. strongly
   * advised to use Camel Case.
   */
  @Nullable private String instance;

  /**
   * Constructor for the Component class
   *
   * @param name Name of the component. Name should be taken from the list of standardized component
   *     names whenever possible. Case Insensitive. strongly advised to use Camel Case.
   */
  public Component(String name) {
    setName(name);
  }

  /**
   * Gets custom data
   *
   * @return Custom data
   */
  @Nullable
  public CustomData getCustomData() {
    return customData;
  }

  /**
   * Sets custom data
   *
   * @param customData Custom data
   */
  public void setCustomData(@Nullable CustomData customData) {
    if (!isValidCustomData(customData)) {
      throw new PropertyConstraintException(customData, "customData is invalid");
    }
    this.customData = customData;
  }

  /**
   * Returns whether the given customData is valid
   *
   * @param customData the customData to check the validity of
   * @return {@code true} if customData is valid, {@code false} if not
   */
  private boolean isValidCustomData(@Nullable CustomData customData) {
    return customData == null || customData.validate();
  }

  /**
   * Adds custom data
   *
   * @param customData Custom data
   * @return this
   */
  public Component withCustomData(@Nullable CustomData customData) {
    setCustomData(customData);
    return this;
  }

  /**
   * Gets electric Vehicle Supply Equipment
   *
   * @return Electric Vehicle Supply Equipment
   */
  @Nullable
  public EVSE getEvse() {
    return evse;
  }

  /**
   * Sets electric Vehicle Supply Equipment
   *
   * @param evse Electric Vehicle Supply Equipment
   */
  public void setEvse(@Nullable EVSE evse) {
    if (!isValidEvse(evse)) {
      throw new PropertyConstraintException(evse, "evse is invalid");
    }
    this.evse = evse;
  }

  /**
   * Returns whether the given evse is valid
   *
   * @param evse the evse to check the validity of
   * @return {@code true} if evse is valid, {@code false} if not
   */
  private boolean isValidEvse(@Nullable EVSE evse) {
    return evse == null || evse.validate();
  }

  /**
   * Adds electric Vehicle Supply Equipment
   *
   * @param evse Electric Vehicle Supply Equipment
   * @return this
   */
  public Component withEvse(@Nullable EVSE evse) {
    setEvse(evse);
    return this;
  }

  /**
   * Gets name of the component. Name should be taken from the list of standardized component names
   * whenever possible. Case Insensitive. strongly advised to use Camel Case.
   *
   * @return Name of the component
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name of the component. Name should be taken from the list of standardized component names
   * whenever possible. Case Insensitive. strongly advised to use Camel Case.
   *
   * @param name Name of the component
   */
  public void setName(String name) {
    if (!isValidName(name)) {
      throw new PropertyConstraintException(name, "name is invalid");
    }
    this.name = name;
  }

  /**
   * Returns whether the given name is valid
   *
   * @param name the name to check the validity of
   * @return {@code true} if name is valid, {@code false} if not
   */
  private boolean isValidName(String name) {
    return name != null && name.length() <= 50;
  }

  /**
   * Gets name of instance in case the component exists as multiple instances. Case Insensitive.
   * strongly advised to use Camel Case.
   *
   * @return Name of instance in case the component exists as multiple instances
   */
  @Nullable
  public String getInstance() {
    return instance;
  }

  /**
   * Sets name of instance in case the component exists as multiple instances. Case Insensitive.
   * strongly advised to use Camel Case.
   *
   * @param instance Name of instance in case the component exists as multiple instances
   */
  public void setInstance(@Nullable String instance) {
    if (!isValidInstance(instance)) {
      throw new PropertyConstraintException(instance, "instance is invalid");
    }
    this.instance = instance;
  }

  /**
   * Returns whether the given instance is valid
   *
   * @param instance the instance to check the validity of
   * @return {@code true} if instance is valid, {@code false} if not
   */
  private boolean isValidInstance(@Nullable String instance) {
    return instance == null || instance.length() <= 50;
  }

  /**
   * Adds name of instance in case the component exists as multiple instances. Case Insensitive.
   * strongly advised to use Camel Case.
   *
   * @param instance Name of instance in case the component exists as multiple instances
   * @return this
   */
  public Component withInstance(@Nullable String instance) {
    setInstance(instance);
    return this;
  }

  public boolean validate() {
    return isValidCustomData(customData)
        && isValidEvse(evse)
        && isValidName(name)
        && isValidInstance(instance);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Component that = (Component) o;
    return Objects.equals(customData, that.customData)
        && Objects.equals(evse, that.evse)
        && Objects.equals(name, that.name)
        && Objects.equals(instance, that.instance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customData, evse, name, instance);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("customData", customData)
        .add("evse", evse)
        .add("name", name)
        .add("instance", instance)
        .add("isValid", validate())
        .toString();
  }
}
