package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Hash hash = new Hash();
    String s = "";
    String x = "x";
    String d = "";
    String c = "c";


    Election[] searchElectionArray = new Election[hash.electionArraySize];
    Politician[] searchPoliticianArray = new Politician[hash.politicianArraySize];

    @FXML
    public TextField politicianName, politicianImage, politicianDOB, electionDate, electionSeats, candidateVotes, searchPoliticianName;
    @FXML
    public Button addPoliticianButton, imagePreviewButton, addElectionButton, addCandidateButton, updatePoliticianButton, updateElectionButton, updateCandidateButton, deletePoliticianButton, deleteElectionButton, deleteCandidateButton, searchPoliticianButton, save, load, reset;
    @FXML
    public ChoiceBox candidatesElection, politicianCountyChoice, politicianCurrentPartyChoice, electionType, electionLocation, candidateElectionChoice, searchElectionYear, searchElectionType, searchPoliticianParty, searchPoliticianLocation, sortBy;
    @FXML
    public ListView politicianPreviousPartyList;
    @FXML
    public ListView viewAll;
    @FXML
    public TreeView drillDownTreeView;
    @FXML
    public ImageView preViewImage;


    public void initialize(URL location, ResourceBundle resources) {
        politicianCountyChoice.getItems().addAll("Antrim", "Armagh ", "Cavan", "Derry", "Donegal", "Down", "Fermanagh", "Monaghan", "Tyrone", "Galway", "Leitrim", "Mayo", "Roscommon", "Sligo", "Carlow", "Dublin", "Kildare", "Kilkenny", "Laois", "Longford", "Louth", "Meath", "Offaly", "Westmeath", "Wexford", "Wicklow", "Clare", "Cork", "Kerry", "Limerick", "Tipperary", "Waterford");
        politicianCurrentPartyChoice.getItems().addAll("Fianna Fail", "Sinn Fein", " Fine Gael", "Green Party", "Labour Party", "Social Democrats", "Solidarity–People Before Profit", "Aontú Right To Change", "Independents", "Human Dignity Alliance", "Workers and Unemployed Action", "Workers Party", "Republican", "Independent Left", "Other");
        electionType.getItems().addAll("General elections", "Seanad elections", "European elections ", "Local elections ", "Presidential elections ", "Referendums");
        electionLocation.getItems().addAll("Antrim", "Armagh ", "Cavan", "Derry", "Donegal", "Down", "Fermanagh", "Monaghan", "Tyrone", "Galway", "Leitrim", "Mayo", "Roscommon", "Sligo", "Carlow", "Dublin", "Kildare", "Kilkenny", "Laois", "Longford", "Louth", "Meath", "Offaly", "Westmeath", "Wexford", "Wicklow", "Clare", "Cork", "Kerry", "Limerick", "Tipperary", "Waterford", "Europe");
        searchElectionYear.getItems().addAll("2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990");
        searchElectionType.getItems().addAll("General elections", "Seanad elections", "European elections ", "Local elections ", "Presidential elections ", "Referendums");
        searchPoliticianParty.getItems().addAll("Fianna Fail", "Sinn Fein", " Fine Gael", "Green Party", "Labour Party", "Social Democrats", "Solidarity–People Before Profit", "Aontú Right To Change", "Independents", "Human Dignity Alliance", "Workers and Unemployed Action", "Workers Party", "Republican", "Independent Left", "Other");
        searchPoliticianLocation.getItems().addAll("Antrim", "Armagh ", "Cavan", "Derry", "Donegal", "Down", "Fermanagh", "Monaghan", "Tyrone", "Galway", "Leitrim", "Mayo", "Roscommon", "Sligo", "Carlow", "Dublin", "Kildare", "Kilkenny", "Laois", "Longford", "Louth", "Meath", "Offaly", "Westmeath", "Wexford", "Wicklow", "Clare", "Cork", "Kerry", "Limerick", "Tipperary", "Waterford");
        sortBy.getItems().addAll("Politician Name A-Z", "Election Type A-Z");
        politicianPreviousPartyList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        politicianPreviousPartyList.getItems().addAll("Fianna Fail", "Sinn Fein", " Fine Gael", "Green Party", "Labour Party", "Social Democrats", "Solidarity–People Before Profit", "Aontú Right To Change", "Independents", "Human Dignity Alliance", "Workers and Unemployed Action", "Workers Party", "Republican", "Independent Left", "Other");

    }


    public void addPolitician(ActionEvent actionEvent) {
        hash.politicianHashFunction(readInPolitician(), hash.politiciansArray);

        String Y = readInPolitician().getPoliticianName();
        candidateElectionChoice.getItems().add(Y);

    }

    public void deletePolitician(ActionEvent actionEvent) {
        Politician politicianToBeDeleted = hash.findPoliticianKey(readInPolitician().getPoliticianName());
        politicianToBeDeleted.setPoliticianCurrentParty(null);
        politicianToBeDeleted.setPoliticianCounty(null);
        politicianToBeDeleted.setPoliticianName(null);
        politicianToBeDeleted.setPoliticianDOB(null);
        politicianToBeDeleted.setPoliticianPreviousParty(null);
        politicianToBeDeleted.setPoliticianImage(null);
    }


    public void updatePolitician(ActionEvent actionEvent) {
        Politician politicianToBeUpdated = hash.findPoliticianKey(readInPolitician().getPoliticianName());
        politicianToBeUpdated.setPoliticianCurrentParty(politicianCurrentPartyChoice.getValue().toString());
        politicianToBeUpdated.setPoliticianCounty(politicianCountyChoice.getValue().toString());
        politicianToBeUpdated.setPoliticianName(politicianName.getText());
        politicianToBeUpdated.setPoliticianDOB(politicianDOB.getText());
        politicianToBeUpdated.setPoliticianPreviousParty(politicianPreviousPartyList.getAccessibleText());
        politicianToBeUpdated.setPoliticianImage(politicianImage.getText());
    }


    public void addElection(ActionEvent actionEvent) {
        hash.electionHashFunction(readInElection(), hash.electionsArray);

        String Y = readInElection().getElectionType() + readInElection().getElectionDate();
        candidatesElection.getItems().add(Y);


    }

    public void deleteElection(ActionEvent actionEvent) {
        Election electionToBeDeleted = hash.findElectionKey(readInElection().getElectionType(), readInElection().getElectionDate());
        electionToBeDeleted.setElectionDate(null);
        electionToBeDeleted.setElectionLocation(null);
        electionToBeDeleted.setElectionType(null);
        electionToBeDeleted.setNumSeats(-1);
    }

    public void updateElection(ActionEvent actionEvent) {
        Election electionToBeUpdated = hash.findElectionKey(readInElection().getElectionDate() , readInElection().getElectionType());
        electionToBeUpdated.setElectionLocation(electionLocation.getValue().toString());
        electionToBeUpdated.setElectionType(electionType.getValue().toString());
        electionToBeUpdated.setElectionDate(electionDate.getText());
        electionToBeUpdated.setNumSeats(Integer.parseInt(electionSeats.getText()));
    }



    public void addCandidate(ActionEvent actionEvent) {
        hash.candidateHashFunction(readInCandidate(), hash.candidatesArray);

    }

    public void deleteCandidate(ActionEvent actionEvent) {
        Candidate candidateToBeDeleted = hash.findCandidateKey(readInCandidate().getCandidate().getPoliticianName());
        candidateToBeDeleted.setCandidate(null);
        candidateToBeDeleted.setCandidateVotes(-1);
        candidateToBeDeleted.setElection(null);
    }


    public void updateCandidate(ActionEvent actionEvent) {
        Candidate candidateToBeUpdated = hash.findCandidateKey(readInCandidate().getCandidate().getPoliticianName());
        Politician newPolitician = hash.findPoliticianKey(candidateElectionChoice.getValue().toString());
        Election newElection = hash.findElectionKey(candidatesElection.getValue().toString(), "");
        candidateToBeUpdated.setCandidate(newPolitician);
        candidateToBeUpdated.setCandidateVotes(Integer.parseInt(candidateVotes.getText()));
        candidateToBeUpdated.setElection(newElection);
    }

    public Politician readInPolitician() {
        return new Politician(politicianName.getText(), politicianDOB.getText(), politicianCountyChoice.getValue().toString(), politicianCurrentPartyChoice.getValue().toString(), politicianPreviousPartyList.getSelectionModel().getSelectedItems().toString(), politicianImage.getText());
    }

    public Election readInElection() {
        return new Election(electionType.getValue().toString(), electionLocation.getValue().toString(), electionDate.getText(), Integer.parseInt(electionSeats.getText()));
    }

    public Candidate readInCandidate() {
        Politician chosenPolitician = hash.findPoliticianKey(candidateElectionChoice.getValue().toString());
        Election chosenElection = hash.findElectionKey(candidatesElection.getValue().toString(), "");
        return new Candidate(chosenPolitician, chosenElection, Integer.parseInt(candidateVotes.getText()));
    }


    public void previewImage(ActionEvent actionEvent) {
        String URL = politicianImage.getText();
        Image preView = new Image(URL);
        preViewImage.setImage(preView);
    }


    public void sortBy(ActionEvent actionEvent) {
        if (sortBy.getValue().toString().equals("Politician Name A-Z")) {
            sortPoliticianByName(searchPoliticianArray, hash.politicianArraySize);

            viewAll.getItems().add("Sorted by Politician Name");
            for (int i = 0; i < searchPoliticianArray.length; i++) {
                if (searchPoliticianArray[i] != null) {
                    viewAll.getItems().add(searchPoliticianArray[i].toString());
                }
            }
            drillDownPolitician();
        }
        if (sortBy.getValue().toString().equals("Election Type A-Z")) {
            sortElectionByType(searchElectionArray, hash.electionArraySize);

            viewAll.getItems().add("Sorted by Election Type");
            for (int i = 0; i < searchElectionArray.length; i++) {
                if (searchElectionArray[i] != null) {
                    viewAll.getItems().add(searchElectionArray[i].toString());
                }
            }
            drillDownElection();
        }
    }


    public void drillDownElection() {

        TreeItem electionItems = new TreeItem("Elections");

        for (int i = 0; i < searchElectionArray.length; i++) {
            if (searchElectionArray[i] != null) {
                TreeItem electionView = new TreeItem(searchElectionArray[i].toString());
                electionItems.getChildren().add(electionView);

                for (int j = 0; j < hash.candidatesArray.length; j++) {
                    Candidate cc = hash.candidatesArray[j];
                    if (cc != null) {
                        if (cc.getElection().toString().equals(searchElectionArray[i].toString())) {
                            TreeItem candidateView = new TreeItem("Candidate Name : " + cc.getCandidate().getPoliticianName() + " , " + " Number of Votes :  " + cc.getCandidateVotes());
                            electionView.getChildren().add(candidateView);

                            TreeItem politicianView = new TreeItem(cc.getCandidate().toString());
                            candidateView.getChildren().add(politicianView);
                        }
                    }
                }
            }
        }
        drillDownTreeView.setRoot(electionItems);
    }

    public void drillDownPolitician() {

        TreeItem Politicians = new TreeItem("Politicians");

        for (int i = 0; i < searchPoliticianArray.length; i++) {

            if (searchPoliticianArray[i] != null) {
                TreeItem politicianNameView = new TreeItem(searchPoliticianArray[i].getPoliticianName());
                Politicians.getChildren().add(politicianNameView);

                TreeItem politicianDetailsView = new TreeItem(searchPoliticianArray[i].toString());
                politicianNameView.getChildren().add(politicianDetailsView);

                for (int j = 0; j < hash.candidatesArray.length; j++) {
                    Candidate cc = hash.candidatesArray[j] ;
                    if (cc != null) {
                        if (cc.getCandidate().getPoliticianName().equals(searchPoliticianArray[i].getPoliticianName())) {

                            TreeItem candidateView = new TreeItem(" Number of Votes :  " + cc.getCandidateVotes() + "," + "Election Type : " + cc.getElection().getElectionType());
                            politicianDetailsView.getChildren().add(candidateView);

                            TreeItem electionView = new TreeItem(" Election Type : " + cc.getElection().getElectionType() + " Election Location : " + cc.getElection().getElectionLocation() + " Election Date : " + cc.getElection().getElectionDate() + " Election Seats : " + cc.getElection().getNumSeats());
                            candidateView.getChildren().add(electionView);

                            for (int k = 0; k < hash.candidatesArray.length; k++) {
                                Candidate ck = hash.candidatesArray[k];
                                if (ck != null) {
                                    if (ck.getElection() == cc.getElection()) {
                                        TreeItem candidatesInElectionAbove = new TreeItem("Candidate Name : " + ck.getCandidate().getPoliticianName() + "Candidate Votes : " + ck.getCandidateVotes());
                                        electionView.getChildren().add(candidatesInElectionAbove);

                                        TreeItem candidatesInElectionAboveFull = new TreeItem(ck.getCandidate().toString());
                                        candidatesInElectionAbove.getChildren().add(candidatesInElectionAboveFull);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        drillDownTreeView.setRoot(Politicians);
    }


    public void searchPolitician(ActionEvent actionEvent) {
        int j = 0;

        if (searchPoliticianName.getText() != null && searchPoliticianParty.getValue() != null && searchPoliticianLocation.getValue() != null) {
            viewAll.getItems().add("Searched For     " + searchPoliticianName.getText() + " from " + searchPoliticianParty.getValue().toString() + "  located in : " + searchPoliticianLocation.getValue().toString());
            for (int i = 0; i < hash.politiciansArray.length; i++) {
                if (hash.politiciansArray[i] != null && hash.politiciansArray[i].getPoliticianName().contains(searchPoliticianName.getText()) && hash.politiciansArray[i].getPoliticianCurrentParty().equals(searchPoliticianParty.getValue().toString()) && hash.politiciansArray[i].getPoliticianCounty().equals(searchPoliticianLocation.getValue().toString())) {
                    searchPoliticianArray[j] = hash.politiciansArray[i];
                    j++;
                }
            }
        } else if (searchPoliticianName.getText() != null && searchPoliticianParty.getValue() != null) {
            viewAll.getItems().add("Searched For     " + searchPoliticianName.getText() + " from " + searchPoliticianParty.getValue().toString());
            for (int i = 0; i < hash.politiciansArray.length; i++) {
                if (hash.politiciansArray[i] != null && hash.politiciansArray[i].getPoliticianName().contains(searchPoliticianName.getText()) && hash.politiciansArray[i].getPoliticianCurrentParty().equals(searchPoliticianParty.getValue().toString())) {
                    searchPoliticianArray[j] = hash.politiciansArray[i];
                    j++;

                }

            }
        } else if (searchPoliticianName.getText() != null && searchPoliticianLocation.getValue() != null) {
            viewAll.getItems().add("Searched For     " + searchPoliticianName.getText() + "  located in : " + searchPoliticianLocation.getValue().toString());
            for (int i = 0; i < hash.politiciansArray.length; i++) {
                if (hash.politiciansArray[i] != null && hash.politiciansArray[i].getPoliticianName().contains(searchPoliticianName.getText()) && hash.politiciansArray[i].getPoliticianCounty().equals(searchPoliticianLocation.getValue().toString())) {
                    searchPoliticianArray[j] = hash.politiciansArray[i];
                    j++;
                }

            }
        } else if (searchPoliticianParty.getValue() != null && searchPoliticianLocation.getValue() != null) {
            viewAll.getItems().add("Searched For     " + searchPoliticianParty.getValue().toString() + "  located in : " + searchPoliticianLocation.getValue().toString());
            for (int i = 0; i < hash.politiciansArray.length; i++) {
                if (hash.politiciansArray[i] != null && hash.politiciansArray[i].getPoliticianCurrentParty().equals(searchPoliticianParty.getValue().toString()) && hash.politiciansArray[i].getPoliticianCounty().equals(searchPoliticianLocation.getValue().toString())) {
                    searchPoliticianArray[j] = hash.politiciansArray[i];
                    j++;

                }
            }
        } else if (searchPoliticianName.getText() != null) {
            viewAll.getItems().add("Searched For     " + searchPoliticianName.getText());
            for (int i = 0; i < hash.politiciansArray.length; i++) {
                if (hash.politiciansArray[i] != null && hash.politiciansArray[i].getPoliticianName().contains(searchPoliticianName.getText())) {
                    searchPoliticianArray[j] = hash.politiciansArray[i];
                    j++;
                }
            }
        } else if (searchPoliticianParty != null) {
            viewAll.getItems().add("Searched For     " + searchPoliticianParty.getValue().toString());
            for (int i = 0; i < hash.politiciansArray.length; i++) {
                if (hash.politiciansArray[i] != null && hash.politiciansArray[i].getPoliticianCurrentParty().equals(searchPoliticianParty.getValue().toString())) {
                    searchPoliticianArray[j] = hash.politiciansArray[i];
                    j++;
                }
            }
        }

        for (int i = 0; i < searchPoliticianArray.length; i++) {
            if (searchPoliticianArray[i] != null) {
                viewAll.getItems().add(searchPoliticianArray[i].toString());
            }
        }

        drillDownPolitician();

    }


    public void searchElection(ActionEvent actionEvent){
            int j = 0;

            if (searchElectionType.getValue() != null && searchElectionYear.getValue() != null) {
                viewAll.getItems().add("Searched For     " + searchElectionType.getValue().toString() + "In" + searchElectionYear.getValue().toString());
                for (int i = 0; i < hash.electionsArray.length; i++) {
                    if (hash.electionsArray[i] != null && hash.electionsArray[i].getElectionType().equals(searchElectionType.getValue().toString()) && hash.electionsArray[i].getElectionDate().contains(searchElectionYear.getValue().toString())) {
                        searchElectionArray[j] =  hash.electionsArray[i] ;
                        j++;
                    }
                }
            }
            if (searchElectionType.getValue() != null) {
                viewAll.getItems().add("Searched For     " + searchElectionType.getValue().toString());
                for (int i = 0; i < hash.electionsArray.length; i++) {
                    if (hash.electionsArray[i] != null && hash.electionsArray[i].getElectionType().equals(searchElectionType.getValue().toString())) {
                        searchElectionArray[j] =  hash.electionsArray[i] ;                        j++;
                    }
                }
            }
            if (searchElectionYear.getValue() != null) {
                viewAll.getItems().add("Searched For  Elections in   " + searchElectionYear.getValue().toString());
                for (int i = 0; i < hash.electionsArray.length; i++) {
                    if (hash.electionsArray[i] != null && hash.electionsArray[i].getElectionDate().contains(searchElectionYear.getValue().toString())) {
                        searchElectionArray[j] =  hash.electionsArray[i] ;                        j++;
                    }
                }
            }

            for (int i = 0; i < searchElectionArray.length; i++) {
                if (searchElectionArray[i] != null) {
                    viewAll.getItems().add(searchElectionArray[i].toString());
                }
            }

        drillDownElection();
        }


    // Sorts an array of strings
    static void sortPoliticianByName(Politician arr[],int n)
    {
        // One by one move boundary of unsorted subarray
        for(int i = 0; i < n - 1; i++) {
            if (arr[i] != null) {

                // Find the minimum element in unsorted array
                int minimum = i;
                Politician minPolitician = arr[i];
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] != null) {

            /*compareTo() will return a -ve value,
            if string1 (arr[j]) is smaller than string2 (minStr)*/
                        // If arr[j] is smaller than minStr

                        if (arr[j].getPoliticianName().compareTo(minPolitician.getPoliticianName()) < 0) {
                            // Make arr[j] as minStr and update min_idx
                            minPolitician = arr[j];
                            minimum = j;
                        }
                    }
                }

                // Swapping the minimum element
                // found with the first element.
                if (minimum != i) {
                    Politician temp = arr[minimum];
                    arr[minimum] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }


    static void sortElectionByType(Election arr[],int n)
    {
        // One by one move boundary of unsorted subarray
        for(int i = 0; i < n - 1; i++) {
            if (arr[i] != null) {

                // Find the minimum element in unsorted array
                int minimum = i;
                Election minElection = arr[i];
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] != null) {

            /*compareTo() will return a -ve value,
            if string1 (arr[j]) is smaller than string2 (minStr)*/
                        // If arr[j] is smaller than minStr

                        if (arr[j].getElectionType().compareTo(minElection.getElectionType()) < 0) {
                            // Make arr[j] as minStr and update min_idx
                            minElection = arr[j];
                            minimum = j;
                        }
                    }
                }

                // Swapping the minimum element
                // found with the first element.
                if (minimum != i) {
                    Election temp = arr[minimum];
                    arr[minimum] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public void reset (ActionEvent actionEvent) throws Exception {
            hash.fillPolitician();
            hash.fillElection();
            hash.saveElections();
            hash.savePoliticians();
        }

        public void save (ActionEvent actionEvent) throws Exception {
            hash.savePoliticians();
            hash.saveElections();
            hash.saveCandidates();
        }

        public void load (ActionEvent actionEvent) throws Exception {
            hash.loadElections();
            hash.loadPoliticians();
            hash.loadCandidates();


            for (int i = 0; i < hash.politiciansArray.length; i++) {
                if (hash.politiciansArray[i] != null) {
                    s = hash.politiciansArray[i].getPoliticianName();
                    candidateElectionChoice.getItems().addAll(s);
                }
            }
            for (int i = 0; i < hash.candidatesArray.length; i++) {
                if (hash.candidatesArray[i] != null) {
                    d = hash.candidatesArray[i].getElection().getElectionType() + hash.candidatesArray[i].getElection().getElectionDate();
                    candidatesElection.getItems().addAll(d);
                }
            }
        }

        public static void errorPopOut (String r){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Input Error");
            alert.setContentText(r);

            alert.showAndWait();
        }

    }
