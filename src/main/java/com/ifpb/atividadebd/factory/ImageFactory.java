/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.atividadebd.factory;

import com.vividsolutions.jts.geom.Geometry;

/**
 *
 * @author aguirre
 */
public class ImageFactory {
     public static String generateSVG(Geometry a, Geometry b) {
        
        StringBuilder builder = new StringBuilder();
        
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        builder.append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//ENG\" \"http://www.w3c.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
        
        ViewBox vb = new ViewBox(a, b);
        
        builder.append("<svg xmlns=\"http://www.w3.org/2000/svg\" "
                + "xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"293\" height=\"256\"");
        builder.append(" viewBox=\"");
        builder.append(vb.getViewBox());
        builder.append("\">");
        
        builder.append("<desc>Desenho das Coordenadas</desc>");
        builder.append("<title>Desenho</title>");
        
        builder.append("<path d=\"");
        builder.append(SVGFactory.getSVG(a));
        builder.append("\" fill=\"red\" fill-opacity=\"1\" />");
        
        builder.append("<path d=\"");
        builder.append(SVGFactory.getSVG(b));
        builder.append("\" fill=\"blue\" fill-opacity=\"1\" />");
        
        builder.append("</svg>");
        
        
        return builder.toString();
    }
}
