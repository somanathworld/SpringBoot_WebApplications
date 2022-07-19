package com.nt.binder;

import java.beans.PropertyEditorSupport;
import java.time.LocalTime;

public class LocalTimeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("LocalTimeEditor.setAsText()"+text);
		//split the string date value whose pattern is hh:mm
		String timeContent[] = text.split(":");
		int hours = Integer.parseInt(timeContent[0]);
		int minutes = Integer.parseInt(timeContent[1]);
		//create LocalTime class obje
		LocalTime lt = LocalTime.of(hours, minutes);
		setValue(lt);
	}
}
