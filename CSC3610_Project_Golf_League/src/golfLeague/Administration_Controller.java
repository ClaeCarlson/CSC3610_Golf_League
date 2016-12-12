package golfLeague;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

public class Administration_Controller {
	@FXML
	Button submit;
	@FXML
	Button addDate;
	@FXML
	Button logout;
	@FXML
	Button restore;
	@FXML
	DatePicker meetDate;
	@FXML
	TextArea schedule;
	@FXML
	Button getSchedule;
	@FXML
	ComboBox<String> time;
	File file = new File("League_Schedule.txt");
	RandomAccessFile input;

	public void initialize() {
		
		addDate.setOnAction(e -> {
			addDate();
		});
		
		submit.setOnAction(e -> {
			createSchedule();
		});
		
		getSchedule.setOnAction(e -> {
			retrieveSchedule();
		});
		
		logout.setOnAction(e -> {

			golfMain.closeWindow(e);

			golfMain.showLogin();

		});
		
		/*restore.setOnAction(e -> {
			try {
				golfMain.showRestorePerson();
			} catch (ClassNotFoundException e1) {
				System.out.println("Class not found");
				//e1.printStackTrace();
			} catch (SQLException e1) {
				System.out.println("SQL");
				//e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println("IO");
				//e1.printStackTrace();
			}
		});*/
	}

	public void setData() {
		twelve("am");
		for (int i = 1; i < 23; i++) {
			if (i == 12)
				twelve("pm");
			for (int n = 0; n < 4; n++) {
				if (i < 12) {
					if (n == 0)
						time.getItems().add(Integer.toString(i) + ":" + Integer.toString(n * 15) + "0am");
					else
						time.getItems().add(Integer.toString(i) + ":" + Integer.toString(n * 15) + "am");
				} else {
					if (n == 0)
						time.getItems().add(Integer.toString(i - 11) + ":" + Integer.toString(n * 15) + "0pm");
					else
						time.getItems().add(Integer.toString(i - 11) + ":" + Integer.toString(n * 15) + "pm");
				}
			}
		}
	}

	public void twelve(String ampm) {
		for (int i = 12; i == 12; i++)
			for (int n = 0; n < 4; n++)
				if (n == 0)
					time.getItems().add(Integer.toString(i) + ":" + Integer.toString(n * 15) + "0" + ampm);
				else
					time.getItems().add(Integer.toString(i) + ":" + Integer.toString(n * 15) + ampm);
	}

	public void addDate() {
		LocalDate add = meetDate.getValue();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		String text = add.format(format);
		LocalDate parsedDate = LocalDate.parse(text, format);
		String addText = parsedDate.format(format);
		try {
			if (addText != null && meetDate.getValue() != null)
				schedule.appendText(addText + " @ " + time.getValue() + "\n");
		} catch (NullPointerException e) {
			alertBox();
		}
	}

	public void createSchedule() {
		try {
			RandomAccessFile output = new RandomAccessFile(file, "rw");
			ZonedDateTime zdt = ZonedDateTime.now();
			java.util.Date date = java.util.Date.from(zdt.toInstant());
			byte[] text = (schedule.getText()).getBytes();
			output.write(text);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void retrieveSchedule() {
		try {
			schedule.clear();
			input = new RandomAccessFile(file, "rw");

			while (input.getFilePointer() != input.length()) {
				String text = input.readLine();
				schedule.appendText(text + "\n");
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void alertBox() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert");
		alert.setHeaderText("User Created:");
		alert.setContentText("Need to select both fields");

		alert.showAndWait().ifPresent(rs -> {
			if (rs == ButtonType.OK) {
			}
		});
	}
}