package gui;

import data.Stats;
import gui_data.BlockSize;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DataDisplayer extends VBox {
	
	private BlockSize blockSize;
	private Label titleLabel;
	private Label moneyLabel;
	private Label nbResidentialLabel;
	private Label nbCommercialLabel;
	private Label nbAdministrativeLabel;
	private Label nbStationLabel;
	private Label monthlyEarnings;
	private Label monthlyExpences;
	private Label nbHabitant;
	private Label nbMaxHabitant;
	private Label moneyAmountPerHabitant;
	private Label nbWorkersCommercial;
	private Label moneyAmountPerCommercialWorker;
	private Label nbWorkersAdministrative;
	private Label expencesPerAdministrativeBuilding;
	private Label expencesPerAdministrativeWorker;
	
	public DataDisplayer(double width, double height) {
		super();
		setBlockSize(new BlockSize(width, height));
		setPrefSize(getBlockSize().getWidth(), getBlockSize().getHeight());
		
		initializeDefaultBlock();
	}
	
	public void initializeDefaultBlock() {
		initializeTitleLabel();
		initializeMoneyLabel();
		initializeMonthlyEarningsLabel();
		initializeMonthlyExpencesLabel();
		initializeNbResidentialLabel();
		initializeNbCommercialLabel();
		initializeNbAdministrativeLabel();
		initializeNbStationLabel();
		getChildren().add(getTitleLabel());
		getChildren().add(getMoneyLabel());
		getChildren().add(getMonthlyEarnings());
		getChildren().add(getMonthlyExpences());
		getChildren().add(getNbResidentialLabel());
		getChildren().add(getNbCommercialLabel());
		getChildren().add(getNbAdministrativeLabel());
		getChildren().add(getNbStationLabel());
	}
	
	public void initializeResidentialBlock() {
		initializeTitleLabel();
		initializeNbHabitantLabel();
		initializeNbMaxHabitantLabel();
		initializeMoneyAmountPerHabitantLabel();
		getChildren().add(getTitleLabel());
		getChildren().add(getNbHabitant());
		getChildren().add(getNbMaxHabitant());
		getChildren().add(getMoneyAmountPerHabitant());
	}
	
	public void initializeCommercialBlock() {
		initializeTitleLabel();
		initializeNbWorkersCommercialLabel();
		initializeMoneyAmountPerCommercialWorkerLabel();
		getChildren().add(getTitleLabel());
		getChildren().add(getNbWorkersCommercial());
		getChildren().add(getMoneyAmountPerCommercialWorker());
	}
	
	public void initializeAdministrativeBlock() {
		initializeTitleLabel();
		initializeNbWorkersAdministrativeLabel();
		initializeExpencesPerAdministrativeBuilding();
		initializeExpencesPerAdministrativeWorker();
		getChildren().add(getTitleLabel());
		getChildren().add(getNbWorkersAdministrative());
		getChildren().add(getExpencesPerAdministrativeBuilding());
		getChildren().add(getExpencesPerAdministrativeWorker());
	}
	
	public void initializeTitleLabel() {
		setTitleLabel(new Label());
		getTitleLabel().setText("Data");
		getTitleLabel().getStyleClass().remove("label");
		getTitleLabel().getStyleClass().add("toolBoxLabel");
	}
	
	public void initializeMoneyLabel() {
		setMoneyLabel(new Label());
		getMoneyLabel().setText("Money :"+Stats.money);
		getMoneyLabel().getStyleClass().remove("label");
		getMoneyLabel().getStyleClass().add("dataLabel");
	}
	
	public void initializeNbResidentialLabel() {
		setNbResidentialLabel(new Label());
		getNbResidentialLabel().setText("Nb residential :"+Stats.nbResidence);
		getNbResidentialLabel().getStyleClass().remove("label");
		getNbResidentialLabel().getStyleClass().add("dataLabel");
	}
	
	public void initializeNbCommercialLabel() {
		setNbCommercialLabel(new Label());
		getNbCommercialLabel().setText("Nb commercial :"+Stats.nbCommercial);
		getNbCommercialLabel().getStyleClass().remove("label");
		getNbCommercialLabel().getStyleClass().add("dataLabel");
	}
	
	public void initializeNbAdministrativeLabel() {
		setNbAdministrativeLabel(new Label());
		getNbAdministrativeLabel().setText("Nb Administrative :"+Stats.nbAdministrative);
		getNbAdministrativeLabel().getStyleClass().remove("label");
		getNbAdministrativeLabel().getStyleClass().add("dataLabel");
	}
	
	public void initializeNbStationLabel() {
		setNbStationLabel(new Label());
		getNbStationLabel().setText("Nb Station :"+Stats.nbStations);
		getNbStationLabel().getStyleClass().remove("label");
		getNbStationLabel().getStyleClass().add("dataLabel");
	}
	
	public void initializeMonthlyEarningsLabel() {
		setMonthlyEarnings(new Label());
		getMonthlyEarnings().setText("Monthly earnings :"+Stats.monthlyRevenues);
		getMonthlyEarnings().getStyleClass().remove("label");
		getMonthlyEarnings().getStyleClass().add("dataLabel");
	}
	
	public void initializeMonthlyExpencesLabel() {
		setMonthlyExpences(new Label());
		getMonthlyExpences().setText("Monthly expences :"+Stats.monthlyExpences);
		getMonthlyExpences().getStyleClass().remove("label");
		getMonthlyExpences().getStyleClass().add("dataLabel");
	}
	
	public void initializeNbHabitantLabel() {
		setNbHabitant(new Label());
		getNbHabitant().setText("Nb habitants :"+Stats.nbHab);
		getNbHabitant().getStyleClass().remove("label");
		getNbHabitant().getStyleClass().add("dataLabel");
	}
	
	public void initializeNbMaxHabitantLabel() {
		setNbMaxHabitant(new Label());
		getNbMaxHabitant().setText("Nb max habitants :"+Stats.nbMaxHab);
		getNbMaxHabitant().getStyleClass().remove("label");
		getNbMaxHabitant().getStyleClass().add("dataLabel");
	}
	
	public void initializeMoneyAmountPerHabitantLabel() {
		setMoneyAmountPerHabitant(new Label());
		getMoneyAmountPerHabitant().setText("Money amount per habitant :"+Stats.moneyAmountPerHab);
		getMoneyAmountPerHabitant().getStyleClass().remove("label");
		getMoneyAmountPerHabitant().getStyleClass().add("dataLabel");
	}
	
	public void initializeNbWorkersCommercialLabel() {
		setNbWorkersCommercial(new Label());
		getNbWorkersCommercial().setText("Nb workers :"+Stats.nbWorkersCommercial);
		getNbWorkersCommercial().getStyleClass().remove("label");
		getNbWorkersCommercial().getStyleClass().add("dataLabel");
	}
	
	public void initializeNbWorkersAdministrativeLabel() {
		setNbWorkersAdministrative(new Label());
		getNbWorkersAdministrative().setText("Nb workers :"+Stats.nbWorkersAdministrative);
		getNbWorkersAdministrative().getStyleClass().remove("label");
		getNbWorkersAdministrative().getStyleClass().add("dataLabel");
	}
	
	public void initializeMoneyAmountPerCommercialWorkerLabel() {
		setMoneyAmountPerCommercialWorker(new Label());
		getMoneyAmountPerCommercialWorker().setText("Money amount per worker :"+Stats.moneyAmountPerCommercialWorker);
		getMoneyAmountPerCommercialWorker().getStyleClass().remove("label");
		getMoneyAmountPerCommercialWorker().getStyleClass().add("dataLabel");
	}
	
	public void initializeExpencesPerAdministrativeBuilding() {
		setExpencesPerAdministrativeBuilding(new Label());
		getExpencesPerAdministrativeBuilding().setText("Expences per building :"+Stats.expencesPerAdministrativeBuildings);
		getExpencesPerAdministrativeBuilding().getStyleClass().remove("label");
		getExpencesPerAdministrativeBuilding().getStyleClass().add("dataLabel");
	}
	
	public void initializeExpencesPerAdministrativeWorker() {
		setExpencesPerAdministrativeWorker(new Label());
		getExpencesPerAdministrativeWorker().setText("Expences per worker :"+Stats.expencesPerAdministrativeWorker);
		getExpencesPerAdministrativeWorker().getStyleClass().remove("label");
		getExpencesPerAdministrativeWorker().getStyleClass().add("dataLabel");
	}
	
	public BlockSize getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(BlockSize blockSize) {
		this.blockSize = blockSize;
	}
	
	public Label getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(Label titleLabel) {
		this.titleLabel = titleLabel;
	}

	public Label getMoneyLabel() {
		return moneyLabel;
	}

	public void setMoneyLabel(Label moneyLabel) {
		this.moneyLabel = moneyLabel;
	}

	public Label getNbResidentialLabel() {
		return nbResidentialLabel;
	}

	public void setNbResidentialLabel(Label nbResidentialLabel) {
		this.nbResidentialLabel = nbResidentialLabel;
	}

	public Label getNbCommercialLabel() {
		return nbCommercialLabel;
	}

	public void setNbCommercialLabel(Label nbCommercialLabel) {
		this.nbCommercialLabel = nbCommercialLabel;
	}

	public Label getNbAdministrativeLabel() {
		return nbAdministrativeLabel;
	}

	public void setNbAdministrativeLabel(Label nbAdministrativeLabel) {
		this.nbAdministrativeLabel = nbAdministrativeLabel;
	}

	public Label getNbStationLabel() {
		return nbStationLabel;
	}

	public void setNbStationLabel(Label nbStationLabel) {
		this.nbStationLabel = nbStationLabel;
	}

	public Label getMonthlyEarnings() {
		return monthlyEarnings;
	}

	public void setMonthlyEarnings(Label monthlyEarnings) {
		this.monthlyEarnings = monthlyEarnings;
	}

	public Label getMonthlyExpences() {
		return monthlyExpences;
	}

	public void setMonthlyExpences(Label monthlyExpences) {
		this.monthlyExpences = monthlyExpences;
	}

	public Label getNbHabitant() {
		return nbHabitant;
	}

	public void setNbHabitant(Label nbHabitant) {
		this.nbHabitant = nbHabitant;
	}

	public Label getNbMaxHabitant() {
		return nbMaxHabitant;
	}

	public void setNbMaxHabitant(Label nbMaxHabitant) {
		this.nbMaxHabitant = nbMaxHabitant;
	}

	public Label getMoneyAmountPerHabitant() {
		return moneyAmountPerHabitant;
	}

	public void setMoneyAmountPerHabitant(Label moneyAmountPerHabitant) {
		this.moneyAmountPerHabitant = moneyAmountPerHabitant;
	}

	public Label getNbWorkersCommercial() {
		return nbWorkersCommercial;
	}

	public void setNbWorkersCommercial(Label nbWorkersCommercial) {
		this.nbWorkersCommercial = nbWorkersCommercial;
	}

	public Label getMoneyAmountPerCommercialWorker() {
		return moneyAmountPerCommercialWorker;
	}

	public void setMoneyAmountPerCommercialWorker(Label moneyAmountPerCommercialWorker) {
		this.moneyAmountPerCommercialWorker = moneyAmountPerCommercialWorker;
	}

	public Label getNbWorkersAdministrative() {
		return nbWorkersAdministrative;
	}

	public void setNbWorkersAdministrative(Label nbWorkersAdministrative) {
		this.nbWorkersAdministrative = nbWorkersAdministrative;
	}

	public Label getExpencesPerAdministrativeBuilding() {
		return expencesPerAdministrativeBuilding;
	}

	public void setExpencesPerAdministrativeBuilding(Label expencesPerAdministrativeBuilding) {
		this.expencesPerAdministrativeBuilding = expencesPerAdministrativeBuilding;
	}

	public Label getExpencesPerAdministrativeWorker() {
		return expencesPerAdministrativeWorker;
	}

	public void setExpencesPerAdministrativeWorker(Label expencesPerAdministrativeWorker) {
		this.expencesPerAdministrativeWorker = expencesPerAdministrativeWorker;
	}
}
