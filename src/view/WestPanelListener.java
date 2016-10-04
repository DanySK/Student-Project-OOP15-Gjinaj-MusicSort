package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

class WestPanelListener extends MouseAdapter  {
	
	int rowSelected;
	
    @Override
	public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger()){
            doPop(e);
            
            JTable source = (JTable)e.getSource();
            int row = source.rowAtPoint( e.getPoint() );
            int column = source.columnAtPoint( e.getPoint() );

            if (! source.isRowSelected(row))
                source.changeSelection(row, column, false, false);
            System.out.println("riga numeroh "+row+" "+"colonna numero:"+ column);
        }
        
    }
    @Override
	public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger()){
            doPop(e);
        }
    }

    private void doPop(MouseEvent e){
        PopUpDemo menu = new PopUpDemo(null, rowSelected);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
    @Override
    public void mouseClicked(MouseEvent e) {
     // TODO Auto-generated method stub
     super.mouseClicked(e);
     JTable source = (JTable)e.getSource();
     int row = source.rowAtPoint( e.getPoint() );
     int column = source.columnAtPoint( e.getPoint() );
     if(e.getClickCount()==2){
            if (! source.isRowSelected(row))
                source.changeSelection(row, column, false, false);
            System.out.println("doppio click in riga numero "+row+" "+"colonna numero:"+ column);
     }
     else{
    	 rowSelected = row;
     }
    }
}

