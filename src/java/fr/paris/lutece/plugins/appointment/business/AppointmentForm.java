/*
 * Copyright (c) 2002-2015, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.appointment.business;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import fr.paris.lutece.portal.service.image.ImageResource;
import fr.paris.lutece.portal.service.rbac.RBACResource;
import fr.paris.lutece.portal.service.util.AppLogService;

/**
 * This is the DTO class for the object AppointmentForm
 * 
 * @author Laurent Payen
 *
 */
public class AppointmentForm implements RBACResource, Cloneable, Serializable {
	/**
	 * Name of the resource type of Appointment Forms
	 */
	public static final String RESOURCE_TYPE = "APPOINTMENT_FORM";

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 307685220867535209L;

	/**
	 * The Form Id
	 */
	private int _nIdForm;

	/**
	 * The title of the form
	 */
	@NotBlank(message = "#i18n{appointment.validation.appointmentform.Title.notEmpty}")
	@Size(max = 255, message = "#i18n{appointment.validation.appointmentform.Title.size}")
	private String _strTitle;

	/**
	 * The description of the form
	 */
	@NotBlank(message = "#i18n{appointment.validation.appointmentform.Description.notEmpty}")
	private String _strDescription;

	/**
	 * The starting time of a working day
	 */
	@NotNull(message = "#i18n{portal.validation.message.notEmpty}")
	private String _strTimeStart;

	/**
	 * The ending time of a working day
	 */
	@NotNull(message = "#i18n{portal.validation.message.notEmpty}")
	private String _strTimeEnd;

	/**
	 * The duration of an appointment
	 */
	@NotNull(message = "#i18n{portal.validation.message.notEmpty}")
	@Min(value = 1, message = "#i18n{portal.validation.message.notEmpty}")
	private int _nDurationAppointments;

	/**
	 * The minimum time from now before a user can take an appointment
	 */
	@NotNull(message = "#i18n{portal.validation.message.notEmpty}")
	@Min(value = 0, message = "#i18n{portal.validation.message.notEmpty}")
	private int _nMinTimeBeforeAppointment;

	/**
	 * True if it is open on Monday (checkbox)
	 */
	private boolean _bIsOpenMonday;

	/**
	 * True if it is open on Tuesday (checkbox)
	 */
	private boolean _bIsOpenTuesday;

	/**
	 * True if it is open on Wednesday (checkbox)
	 */
	private boolean _bIsOpenWednesday;

	/**
	 * True if it is open on Thursday (checkbox)
	 */
	private boolean _bIsOpenThursday;

	/**
	 * True if it is open on Friday (checkbox)
	 */
	private boolean _bIsOpenFriday;

	/**
	 * True if it is open on Saturday (checkbox)
	 */
	private boolean _bIsOpenSaturday;

	/**
	 * True if it is open on Sunday (checkbox)
	 */
	private boolean _bIsOpenSunday;

	/**
	 * Starting validity date of the form
	 */
	private Date _dateStartValidity;

	/**
	 * Ending validity date of the form
	 */
	private Date _DateEndValidity;

	/**
	 * Date of modification of the form
	 */
	private Date _dateOfModification;

	/**
	 * True if the form is active
	 */
	private boolean _bIsActive;

	/**
	 * True if the title has to be displayed on the front office
	 */
	private boolean _bDisplayTitleFo;

	/**
	 * Number of weeks to display the form to the user
	 */
	private int _nNbWeeksToDisplay;

	/**
	 * The maximum capacity per slot
	 */
	@Min(value = 1, message = "#i18n{portal.validation.message.notEmpty}")
	private int _nMaxCapacityPerSlot;

	/**
	 * The maximum number of people authorized for an appointment
	 */
	@Min(value = 1, message = "#i18n{portal.validation.message.notEmpty}")
	private int _nMaxPeoplePerAppointment = 0;

	/**
	 * The workflow Id
	 */
	private int _nIdWorkflow;

	/**
	 * True if the captcha is enabled
	 */
	private boolean _bEnableCaptcha;

	/**
	 * The Calendar Template Id
	 */
	@Min(value = 1, message = "#i18n{portal.validation.message.notEmpty}")
	private int _nCalendarTemplateId;

	/**
	 * The Reference of the form (that will be in front of the reference
	 * appointment)
	 */
	private String _strReference;

	/**
	 * True if the email is enabled
	 */
	private boolean _bEnableMandatoryEmail;

	/**
	 * The icon of the form
	 */
	private ImageResource _imageResource;

	/**
	 * The category of the form
	 */
	private String _strCategory;

	/**
	 * The reservation rule id (Rules that need to be applied to the form)
	 */
	private int _nIdReservationRule;

	/**
	 * Minimum of days between two appointments of a same user
	 */
	private int _nNbDaysBeforeNewAppointment;

	/**
	 * Returns the IdForm
	 * 
	 * @return The IdForm
	 */
	public int getIdForm() {
		return _nIdForm;
	}

	/**
	 * Sets the IdForm
	 * 
	 * @param nIdForm
	 *            The IdForm
	 */
	public void setIdForm(int nIdForm) {
		_nIdForm = nIdForm;
	}

	/**
	 * Returns the Title
	 * 
	 * @return The Title
	 */
	public String getTitle() {
		return _strTitle;
	}

	/**
	 * Sets the Title
	 * 
	 * @param strTitle
	 *            The Title
	 */
	public void setTitle(String strTitle) {
		_strTitle = strTitle;
	}

	/**
	 * Get the date of modification of the form
	 * 
	 * @return the date of modification
	 */
	public Date getDateOfModification() {
		return _dateOfModification;
	}

	/**
	 * Set the date of modification of the form
	 * 
	 * @param dateOfModification
	 *            the date to set
	 */
	public void setDateOfModification(Date dateOfModification) {
		this._dateOfModification = dateOfModification;
	}

	/**
	 * Get the description of the appointment form
	 * 
	 * @return The description of the appointment form
	 */
	public String getDescription() {
		return _strDescription;
	}

	/**
	 * Set the description of the appointment form
	 * 
	 * @param strDescription
	 *            The description of the appointment form
	 */
	public void setDescription(String strDescription) {
		this._strDescription = strDescription;
	}

	/**
	 * Returns the Reference of the form
	 * 
	 * @return The reference of the form
	 */
	public String getReference() {
		return _strReference;
	}

	/**
	 * Sets the Reference of the form
	 * 
	 * @param the
	 *            reference to set
	 * 
	 */
	public void setReference(String strRef) {
		_strReference = strRef;
	}

	/**
	 * Returns the starting time of the working day of the form
	 * 
	 * @return The starting time
	 */
	public String getTimeStart() {
		return _strTimeStart;
	}

	/**
	 * Sets the starting time of the working day of the form
	 * 
	 * @param the
	 *            starting time to set The TimeStart
	 */
	public void setTimeStart(String timeStart) {
		_strTimeStart = timeStart;
	}

	/**
	 * Returns the ending time of the working day of the form
	 * 
	 * @return The ending time
	 */
	public String getTimeEnd() {
		return _strTimeEnd;
	}

	/**
	 * Sets the ending time of the working day of the form
	 * 
	 * @param the
	 *            ending time to set
	 */
	public void setTimeEnd(String timeEnd) {
		_strTimeEnd = timeEnd;
	}

	/**
	 * Returns the duration of an appointment
	 * 
	 * @return The duration of an appointment
	 */
	public int getDurationAppointments() {
		return _nDurationAppointments;
	}

	/**
	 * Sets the duration of an appointment
	 * 
	 * @param nDurationAppointments
	 *            The Duration of an Appointments
	 */
	public void setDurationAppointments(int nDurationAppointments) {
		_nDurationAppointments = nDurationAppointments;
	}

	/**
	 * Get the minimum time from now before a user can take an appointment
	 * 
	 * @return
	 */
	public int getMinTimeBeforeAppointment() {
		return _nMinTimeBeforeAppointment;
	}

	public void setMinTimeBeforeAppointment(int nMinTimeBeforeAppointment) {
		this._nMinTimeBeforeAppointment = nMinTimeBeforeAppointment;
	}

	/**
	 * Returns if it is open on Monday (if the checkbox is checked or not)
	 * 
	 * @return true if it is open on Monday
	 */
	public boolean getIsOpenMonday() {
		return _bIsOpenMonday;
	}

	/**
	 * Sets if it is open on Monday (if the checkbox is checked or not)
	 * 
	 * @param bIsOpenMonday
	 *            The boolean value
	 */
	public void setIsOpenMonday(boolean bIsOpenMonday) {
		_bIsOpenMonday = bIsOpenMonday;
	}

	/**
	 * Returns if it is open on Tuesday (if the checkbox is checked or not)
	 * 
	 * @return true if it is open on Tuesday
	 */
	public boolean getIsOpenTuesday() {
		return _bIsOpenTuesday;
	}

	/**
	 * Sets if it is open on Tuesday (if the checkbox is checked or not)
	 * 
	 * @param bIsOpenTuesday
	 *            The boolean value
	 */
	public void setIsOpenTuesday(boolean bIsOpenTuesday) {
		_bIsOpenTuesday = bIsOpenTuesday;
	}

	/**
	 * Returns if it is open on Wednesday (if the checkbox is checked or not)
	 * 
	 * @return true if it is open on Wednesday
	 */
	public boolean getIsOpenWednesday() {
		return _bIsOpenWednesday;
	}

	/**
	 * Sets if it is open on Wednesday (if the checkbox is checked or not)
	 * 
	 * @param bIsOpenWednesday
	 *            The boolean value
	 */
	public void setIsOpenWednesday(boolean bIsOpenWednesday) {
		_bIsOpenWednesday = bIsOpenWednesday;
	}

	/**
	 * Returns if it is open on Thursday (if the checkbox is checked or not)
	 * 
	 * @return true if it is open on Thursday
	 */
	public boolean getIsOpenThursday() {
		return _bIsOpenThursday;
	}

	/**
	 * Sets if it is open on Thursday (if the checkbox is checked or not)
	 * 
	 * @param bIsOpenThursday
	 *            The boolean value
	 */
	public void setIsOpenThursday(boolean bIsOpenThursday) {
		_bIsOpenThursday = bIsOpenThursday;
	}

	/**
	 * Returns if it is open on Friday (if the checkbox is checked or not)
	 * 
	 * @return true if it is open on Friday
	 */
	public boolean getIsOpenFriday() {
		return _bIsOpenFriday;
	}

	/**
	 * Sets if it is open on Friday (if the checkbox is checked or not)
	 * 
	 * @param bIsOpenFriday
	 *            The boolean value
	 */
	public void setIsOpenFriday(boolean bIsOpenFriday) {
		_bIsOpenFriday = bIsOpenFriday;
	}

	/**
	 * Returns if it is open on Saturday (if the checkbox is checked or not)
	 * 
	 * @return true if it is open on Saturday
	 */
	public boolean getIsOpenSaturday() {
		return _bIsOpenSaturday;
	}

	/**
	 * Sets if it is open on Saturday (if the checkbox is checked or not)
	 * 
	 * @param bIsOpenSaturday
	 *            The boolean value
	 */
	public void setIsOpenSaturday(boolean bIsOpenSaturday) {
		_bIsOpenSaturday = bIsOpenSaturday;
	}

	/**
	 * Returns if it is open on Monday (if the checkbox is checked or not)
	 * 
	 * @return true if it is open on Sunday
	 */
	public boolean getIsOpenSunday() {
		return _bIsOpenSunday;
	}

	/**
	 * Sets if it is open on Sunday (if the checkbox is checked or not)
	 * 
	 * @param bIsOpenSunday
	 *            The boolean value
	 */
	public void setIsOpenSunday(boolean bIsOpenSunday) {
		_bIsOpenSunday = bIsOpenSunday;
	}

	/**
	 * Returns the starting validity date of the form
	 * 
	 * @return The starting validity date of the form
	 */
	public Date getDateStartValidity() {
		return _dateStartValidity;
	}

	/**
	 * Sets the starting validity date of the form
	 * 
	 * @param dateDateStartValidity
	 *            The starting validity date
	 */
	public void setDateStartValidity(Date dateDateStartValidity) {
		_dateStartValidity = dateDateStartValidity;
	}

	/**
	 * Returns the ending validity date of the form
	 * 
	 * @return The ending validity date
	 */
	public Date getDateEndValidity() {
		return _DateEndValidity;
	}

	/**
	 * Sets the ending validity date of the form
	 * 
	 * @param dateDateEndValidity
	 *            the ending validity date to set
	 */
	public void setDateEndValidity(Date dateDateEndValidity) {
		_DateEndValidity = dateDateEndValidity;
	}

	/**
	 * Returns if the form is active or not
	 * 
	 * @return true if the form is active
	 */
	public boolean getIsActive() {
		return _bIsActive;
	}

	/**
	 * Sets if the form is active or not
	 * 
	 * @param bIsActive
	 *            The boolean value
	 */
	public void setIsActive(boolean bIsActive) {
		_bIsActive = bIsActive;
	}

	/**
	 * Returns if the title of the form has to be displayed on the front office
	 * 
	 * @return true if it has to be displayed
	 */
	public boolean getDisplayTitleFo() {
		return _bDisplayTitleFo;
	}

	/**
	 * Sets if the title of the form has to be displayed on the front office
	 * 
	 * @param bDisplayTitleFo
	 *            The boolean value
	 */
	public void setDisplayTitleFo(boolean bDisplayTitleFo) {
		_bDisplayTitleFo = bDisplayTitleFo;
	}

	/**
	 * Returns the number of weeks to display the form to the user (for an
	 * appointment)
	 * 
	 * @return The number of weeks to display
	 */
	public int getNbWeeksToDisplay() {
		return _nNbWeeksToDisplay;
	}

	/**
	 * Sets the number of weeks to display the form to the user (for an
	 * appointment)
	 * 
	 * @param nNbWeeksToDisplay
	 *            the number of weeks to display the form
	 */
	public void setNbWeeksToDisplay(int nNbWeeksToDisplay) {
		_nNbWeeksToDisplay = nNbWeeksToDisplay;
	}

	/**
	 * Get the id of the workflow associated with this appointment form
	 * 
	 * @return The id of the workflow
	 */
	public int getIdWorkflow() {
		return _nIdWorkflow;
	}

	/**
	 * Set the id of the workflow associated with this appointment form
	 * 
	 * @param nIdWorkflow
	 *            The id of the workflow
	 */
	public void setIdWorkflow(int nIdWorkflow) {
		_nIdWorkflow = nIdWorkflow;
	}

	/**
	 * Check if the captcha is enabled for this appointment form
	 * 
	 * @return True if the captcha is enabled, false otherwise
	 */
	public boolean getEnableCaptcha() {
		return _bEnableCaptcha;
	}

	/**
	 * Enable or disable the captcha for this appointment form
	 * 
	 * @param bEnableCaptcha
	 *            True to enable the captcha, false to disable it
	 */
	public void setEnableCaptcha(boolean bEnableCaptcha) {
		this._bEnableCaptcha = bEnableCaptcha;
	}

	/**
	 * Get the id of the calendar template of this appointment form
	 * 
	 * @return The id of the calendar template of this appointment form
	 */
	public int getCalendarTemplateId() {
		return _nCalendarTemplateId;
	}

	/**
	 * Set the id of the calendar template of this appointment form
	 * 
	 * @param nCalendarTemplateId
	 *            The id of the calendar template of this appointment form
	 */
	public void setCalendarTemplateId(int nCalendarTemplateId) {
		_nCalendarTemplateId = nCalendarTemplateId;
	}

	/**
	 * Check if the email is mandatory or not
	 * 
	 * @return true if enable mandatory email
	 */
	public boolean getEnableMandatoryEmail() {
		return _bEnableMandatoryEmail;
	}

	/**
	 * Set enable mandatory email
	 * 
	 * @param bEnableMandatoryEmail
	 *            the boolean value for mandatory email
	 */
	public void setEnableMandatoryEmail(boolean bEnableMandatoryEmail) {
		this._bEnableMandatoryEmail = bEnableMandatoryEmail;
	}

	/**
	 * Get the Icon of the form
	 * 
	 * @return the icon of the form
	 */
	public ImageResource getIcon() {
		return _imageResource;
	}

	/**
	 * Set the icon of the form
	 * 
	 * @param imgIcon
	 *            the icon to associate to the form
	 */
	public void setIcon(ImageResource imgIcon) {
		this._imageResource = imgIcon;
	}

	/**
	 * Get the number of days between two appointments of the same user
	 * 
	 * @return the delay in days
	 */
	public int getNbDaysBeforeNewAppointment() {
		return _nNbDaysBeforeNewAppointment;
	}

	/**
	 * Set the number of days between two appointments of the same user (0 : no
	 * delay)
	 * 
	 * @param nNbDaysBeforeNewAppointment
	 *            the number of days to set
	 */
	public void setNbDaysBeforeNewAppointment(int nNbDaysBeforeNewAppointment) {
		this._nNbDaysBeforeNewAppointment = nNbDaysBeforeNewAppointment;
	}

	/**
	 * Get the category of the form
	 * 
	 * @return the category of the form
	 */
	public String getCategory() {
		return _strCategory;
	}

	/**
	 * Set the category of the form
	 * 
	 * @param strCategory
	 *            the category to set
	 */
	public void setCategory(String strCategory) {
		_strCategory = strCategory;
	}

	/**
	 * Get the Reservation Rule Id of the form
	 * 
	 * @return the reservation rule Id
	 */
	public int getIdReservationRule() {
		return _nIdReservationRule;
	}

	/**
	 * Set the reservation rule Id
	 * 
	 * @param nIdReservationRule
	 *            the reservation Rule Id to set
	 */
	public void setIdReservationRule(int nIdReservationRule) {
		this._nIdReservationRule = nIdReservationRule;
	}

	/**
	 * Get the max capacity per slot
	 * 
	 * @return the max capacity per slot
	 */
	public int getMaxCapacityPerSlot() {
		return _nMaxCapacityPerSlot;
	}

	/**
	 * Set the max capacity per slot
	 * 
	 * @param nMaxCapacityPerSlot
	 *            the max capacity to set
	 */
	public void setMaxCapacityPerSlot(int nMaxCapacityPerSlot) {
		this._nMaxCapacityPerSlot = nMaxCapacityPerSlot;
	}

	/**
	 * Get the maximum of people authorized per appointment (not per slot, per
	 * slot it's _nMaxCapacityPerSlot)
	 * 
	 * @return the max people
	 */
	public int getMaxPeoplePerAppointment() {
		return _nMaxPeoplePerAppointment;
	}

	/**
	 * Set the maximum of people authorized per appointment (not per slot)
	 * 
	 * @param nMaxPeoplePerAppointment
	 *            the maximum people per appointment
	 */
	public void setMaxPeoplePerAppointment(int nMaxPeoplePerAppointment) {
		this._nMaxPeoplePerAppointment = nMaxPeoplePerAppointment;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getResourceTypeCode() {
		return RESOURCE_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getResourceId() {
		return Integer.toString(getIdForm());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			AppLogService.error(e.getMessage(), e);

			return null;
		}
	}

}
