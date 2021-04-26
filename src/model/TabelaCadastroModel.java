/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;        
/**
 *
 * @author JeffersonAndrade
 */
public class TabelaCadastroModel extends AbstractTableModel{
    
    private ArrayList linhas=null;
    private String[] colunas=null;

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[]linha=(Object[])getLinhas().get(rowIndex);
        return linha[columnIndex];
    }
    
    public TabelaCadastroModel(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }
    
    @Override
    public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "ID";
                case 1:
                    return "Qt.";
                case 2:
                    return "Nome";
                case 3:
                    return "Telefone";
                case 4:
                    return "Embarque";
                case 5:
                    return "Destino";
                case 6:
                    return "Situação";
                case 7:
                    return "Valor PAGO";
                case 8:
                    return "Valor TOTAL";
                case 9:
                    return "Data viagem";
            }
            return null;
        }
}
