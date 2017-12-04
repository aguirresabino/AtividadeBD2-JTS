package com.ifpb.atividadebd.view;

import com.ifpb.atividadebd.factory.ImageFactory;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.SVGPath;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class FXMLController implements Initializable {
    
    @FXML
    private Button btOk;
    @FXML
    private TextField tfGeometria1;
    @FXML
    private TextField tfGeometria2;
    @FXML
    private Label lContains;
    @FXML
    private Label lCovers;
    @FXML
    private Label lCoveredBy;
    @FXML
    private Label lCrosses;
    @FXML
    private Label lDisjoint;
    @FXML
    private Label lDistance;
    @FXML
    private Label lOverlaps;
    @FXML
    private Label lTouches;
    @FXML
    private Label lWithin;
    @FXML
    private WebView geomView;
    @FXML
    private WebEngine engine;
    
    public void pressionaBotao(){
         WKTReader reader = new WKTReader();
         Geometry geoA;
         Geometry geob;
         engine = geomView.getEngine();
        
        try{
           geoA = reader.read(tfGeometria1.getText());
           geob = reader.read(tfGeometria2.getText());
                    
           SVGPath svg = new SVGPath();
           String path = ImageFactory.generateSVG(geoA, geob);
           svg.setContent(path);
           
           engine.loadContent(path);
           

           lContains.setText(geoA.contains(geob) ? "V" : "F");
           lCovers.setText(geoA.covers(geob) ? "V" : "F");
           lCoveredBy.setText(geoA.coveredBy(geob) ? "V" : "F");
           lCrosses.setText(geoA.crosses(geob) ? "V" : "F");
           lDisjoint.setText(geoA.disjoint(geob) ? "V" : "F");
           Double distancia = geoA.distance(geob);
           lDistance.setText(distancia.toString());
           lOverlaps.setText(geoA.overlaps(geob) ? "V" : "F");
           lTouches.setText(geoA.overlaps(geob) ? "V" : "F");
           lWithin.setText(geoA.within(geob) ? "V" : "F");
            
        } catch (ParseException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
