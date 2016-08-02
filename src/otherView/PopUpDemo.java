package otherView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpDemo extends JPopupMenu{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuItem remove;
	JMenuItem aggiungiaPlaylist;
	
    public PopUpDemo(){
    	remove = new JMenuItem("remove");
    	remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("premuto rem");
				
			}
		});
    	aggiungiaPlaylist= new JMenuItem("AddToPlaylist");
    	add(aggiungiaPlaylist);
        add(remove);
        PopUpDemo p= new PopUpDemo();
        
        JMenuItem remove = new JMenuItem("cc");
        p.add(remove);
        this.add(p);
        
        
    }

}
