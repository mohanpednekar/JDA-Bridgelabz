package com.jda.clinique.models;

import java.util.ArrayList;
import java.util.Date;

import com.jda.clinique.util.Enums.AppointmentSlot;

public class Appointment {
  private int                doctorId;
  private Date               date;
  private AppointmentSlot    slot;
  private ArrayList<Integer> patientIds = new ArrayList<>();

  public Appointment(int doctorId, Date date, AppointmentSlot slot) {
    this.doctorId = doctorId;
    this.date = date;
    this.slot = slot;
  }
  
  public int getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(int doctorId) {
    this.doctorId = doctorId;
  }

  public ArrayList<Integer> getPatientIds() {
    return patientIds;
  }

  public void setPatientIds(ArrayList<Integer> patientIds) {
    this.patientIds = patientIds;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public AppointmentSlot getSlot() {
    return slot;
  }

  public void setSlot(AppointmentSlot slot) {
    this.slot = slot;
  }

  public void addPatientId(int patientId) {
    patientIds.add(patientId);
  }
  
  public int numberOfBookings() {
    return getPatientIds().size();
  }
  
  public boolean checkMatch(Appointment a2) {
    if (doctorId != a2.getDoctorId()) { return false; }
    if (!date.equals(a2.getDate())) { return false; }
    if (!slot.equals(a2.getSlot())) { return false; }
    return true;
  }

}
