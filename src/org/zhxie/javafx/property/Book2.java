package org.zhxie.javafx.property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book2 {
	private final StringProperty title = new SimpleStringProperty(this,
			"title", "Unknown");

	public final StringProperty titleProperty() {
		return title;
	}

	public final String getTitle() {
		return title.get();
	}

	public final void setTitle(String title) {
		this.title.set(title);
	}
}