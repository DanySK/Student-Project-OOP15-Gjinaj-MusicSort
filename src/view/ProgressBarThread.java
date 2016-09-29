package view;

import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import controller.MainController;

public class ProgressBarThread extends Thread {
	private JSlider progressSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
	JPanel southP;
	int n = 0;
	MainController controller;
	JLabel timerCounter;
	public static int startSec;
	static int min = 0;
	static int h = 0;
	private boolean songInPause;

	public ProgressBarThread(JSlider progressSlider, SouthPanel southPanel, MainController contr, JLabel labelTimeCounter) {
		this.progressSlider = progressSlider;
		this.southP = southPanel;
		controller = contr;
		timerCounter = labelTimeCounter;
	}

	@Override
	public void run() {
		startSec = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		while (true) {
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					@Override
					public void run() {
						southP.revalidate();
						if (!songInPause) {
							try {
								int nowSec = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
								int tmpSec = nowSec - startSec;
								if (tmpSec == 60) {
									startSec = nowSec;
									min++;
								}
								timerCounter.setText("" + String.valueOf(h) + ":" + String.valueOf(min) + ":"
										+ String.valueOf(nowSec - startSec));
								// System.out.println(controller.getPos());
								Thread.sleep(70);
								progressSlider.setValue(controller.getSongPos());
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void setPaused(final boolean value) {
		this.songInPause = value;
	}

	public  void cleanBarData() {
		// TODO Auto-generated method stub
		startSec = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		min = 0;
		h = 0;
		progressSlider.setValue(0);
		
	}
}