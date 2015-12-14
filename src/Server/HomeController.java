package Server;

/**
 * Created by ABIR BINDU on 12/14/2015.
 */


        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.*;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.util.Callback;

public class HomeController {

    @FXML
    private TableView<Match> Scorecard;

    @FXML
    private TableColumn<Match,Integer> Time;

    @FXML
    private TableColumn<Match,String> Team1;

    @FXML
    private TableColumn<Match,Integer> Score1;

    @FXML
    private TableColumn<Match,Integer> Score2;

    @FXML
    private TableColumn<Match,String> Team2;

    @FXML
    private TableColumn<Match,String> Explore;

    @FXML
    private TableColumn<Match,String> Remove;

    @FXML
    private TextField addTeam1;

    @FXML
    private TextField addTeam2;

    @FXML
    private Button addMatchButton;

    @FXML
    private TextField contributorName;

    @FXML
    private TextField contributorPassword;

    Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    public void setMatches(ObservableList<Match> matches){
        Scorecard.setItems(matches);
    }


    @FXML
    void addMatchAction(ActionEvent event) {

        Contributor contributor=new Contributor(contributorName.getText(),contributorPassword.getText());
        Match match=new Match(addTeam1.getText(), addTeam2.getText());
        main.matches.add(match);
        main.cTable.put(contributor, match);
    }

    @FXML
    public void initialize(){
        Time.setCellValueFactory(new PropertyValueFactory<Match, Integer>("simpleMinute"));
        Team1.setCellValueFactory(new PropertyValueFactory<Match, String>("simpleFirstTeam"));
        Team2.setCellValueFactory(new PropertyValueFactory<Match, String>("simpleLastTeam"));
        Score1.setCellValueFactory(new PropertyValueFactory<Match, Integer>("simpleScoreFirst"));
        Score2.setCellValueFactory(new PropertyValueFactory<Match, Integer>("simpleScoreLast"));
        Explore.setCellValueFactory(new PropertyValueFactory<Match, String>("explore"));


        Callback<TableColumn<Match, String>, TableCell<Match, String>> cellFactory =
                new Callback<TableColumn<Match, String>, TableCell<Match, String>>() {
                    @Override
                    public TableCell call( final TableColumn<Match, String> param ) {
                        final TableCell<Match, String> cell = new TableCell<Match, String>() {
                            final Button btn = new Button("Explore");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem( item, empty );
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                }
                                else {
                                    // action of 'Select' button click
                                    btn.setOnAction((ActionEvent event) -> {
                                                // System.out.println("hi");
                                                Match match= getTableView().getItems().get(getIndex());
                                                try {
                                                    System.out.println("hi");
                                                    main.showMatchPage(match);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                    );
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        Explore.setCellFactory(cellFactory);

        Remove.setCellValueFactory(new PropertyValueFactory<Match, String>("remove"));

        Callback <TableColumn<Match, String>, TableCell<Match, String>> cellFactory2 =
                new Callback<TableColumn<Match, String>, TableCell<Match, String>>() {
                    @Override
                    public TableCell call( final TableColumn<Match, String> param ) {
                        final TableCell<Match, String> cell = new TableCell<Match, String>() {
                            final Button btn = new Button("remove");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem( item, empty );
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                }
                                else {
                                    // action of 'Select' button click
                                    btn.setOnAction((ActionEvent event) -> {
                                                System.out.println("hello");

                                            }
                                    );
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        Remove.setCellFactory(cellFactory2);


    }

}

