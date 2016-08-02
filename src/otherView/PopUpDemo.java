package otherView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;



public class PopUpDemo extends JPopupMenu{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuItem remove;
	JMenuItem salva_nei_preferiti;
	JMenu sectionsMenu = new JMenu("Aggiungi Alla Playlist");
	JMenuItem menuItem1 = new JMenuItem("Playlist 1");
	JMenuItem menuItem2 = new JMenuItem("Playlist 2");
	
    public PopUpDemo(){
    	remove = new JMenuItem("remove");
    	remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("premuto rem");
				
			}
		});
    	//sub menu
    	
    	this.add(remove);
    	this.add(remove);
    	
    	sectionsMenu.add(menuItem1 );

    	sectionsMenu.add(menuItem2 );
    	
    	this.add(sectionsMenu);
    }

}
