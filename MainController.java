package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

	// declaration of fxml variables
	@FXML
	private Button _submit;
	@FXML
	private RadioButton _rdBtnCse;
	@FXML
	private RadioButton _rdBtnBus;
	@FXML
	private TextField _nameText;
	@FXML
	private TextField _addText;
	@FXML
	private TextField _provinceText;
	@FXML
	private TextField _cityText;
	@FXML
	private TextField _postalText;
	@FXML
	private TextField _phNoText;
	@FXML
	private TextField _email;
	@FXML
	private CheckBox _volCheck;
	@FXML
	private ComboBox<String> _courseList;
	@FXML
	private TextArea _courseArea;
	@FXML
	private TextArea _detailsOfCourse;
	@FXML
	private ListView<String> _courseDetails;
	@FXML
	private Label _label;
	@FXML
	private TextArea _area;

	// array declaration for computer courses
	ObservableList<String> compCourse = FXCollections.observableArrayList("Java", "Python", "C#");
	// array declaration for business courses
	ObservableList<String> busCourse = FXCollections.observableArrayList("Management", "Administration", "Analytics");

	@FXML
	private void initialize() {
		// handling events on a particular click
		_submit.setOnAction(new ShowHandlerClass());
		_courseList.setOnAction(new RadioClass());
		_courseList.setOnAction(new ComboClass());

	}

	// Inner class to handle OK button click
	public class ShowHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			onSubmitDetailsClicked();
		}
	}

	// Inner class to handle Combo box click
	public class ComboClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			list();
		}
	}

	// Inner Class to handle Radio buttons selection
	public class RadioClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			onCourse();
		}
	}

	// method to be invoked on clicking submit button
	@FXML
	private void onSubmitDetailsClicked() {
		// getting values from text boxes and storing them in a particular
		// variable
		String name = _nameText.getText();
		String address = _addText.getText();
		String province = _provinceText.getText();
		String city = _cityText.getText();
		String postal = _postalText.getText();
		String phNo = _phNoText.getText();
		// to display info in textArea on clicking submit button
		_detailsOfCourse.setText(name + " , " + address + " ," + province + " ," + city + " ," + postal + " ," + phNo
				+ "\n" + "Courses" + "\n" + _courseDetails.getItems());
	}

	// method for combo box item display for particular radio button selection
	@FXML
	private void onCourse() {

		if (_rdBtnCse.isSelected())// check condition
		{
			// adding computer science array items to combo dropdown on this
			// selection
			_courseList.setItems(compCourse);
			_courseList.setVisible(true);// set visibility

		} else if (_rdBtnBus.isSelected())// check condition
		{
			// adding business array items to combo dropdown on this selection
			_courseList.setItems(busCourse);
			_courseList.setVisible(true);// set visibility

		} else {
			_courseDetails.getItems().clear();
		}
	}

	// method to populate listview with particular item selected from combobox
	// on mouse click
	@FXML
	private void list() {
		// storing values in a string on clicking particular item of a combobox
		String cse = _courseList.getValue().toString();

		// check condition for not allowing duplicate values
		// runs only if condition inside if is true
		if (!_courseDetails.getItems().contains(cse)) {
			_courseDetails.getItems().add(cse);// adding selected values to the listview
		} else {
			System.out.println(" Courses were already added");// if user tries to add one course more than once



		}

	}
}
