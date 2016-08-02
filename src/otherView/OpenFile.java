//package otherView;
//
//import java.io.File;
//
//import javax.swing.JFileChooser;
//import javax.swing.filechooser.FileFilter;
//
//public class OpenFile {
//	private boolean isPause;
//	boolean isPlaying;
//
//	private void openFile() {
//		JFileChooser fileChooser = null;
//		
//		String lastOpenPath;
//		 String audioFilePath;
//		if (lastOpenPath != null && !lastOpenPath.equals("")) {
//			fileChooser = new JFileChooser(lastOpenPath);
//		} else {
//			fileChooser = new JFileChooser();
//		}
//		
//		FileFilter wavFilter = new FileFilter() {
//			@Override
//			public String getDescription() {
//				return "Sound file (*.WAV)";
//			}
//
//			@Override
//			public boolean accept(File file) {
//				if (file.isDirectory()) {
//					return true;
//				} else {
//					return file.getName().toLowerCase().endsWith(".wav");
//				}
//			}
//		};
//
//		
//		fileChooser.setFileFilter(wavFilter);
//		fileChooser.setDialogTitle("Open Audio File");
//		fileChooser.setAcceptAllFileFilterUsed(false);
//
//		//int userChoice = fileChooser.showOpenDialog();
////		if (userChoice == JFileChooser.APPROVE_OPTION) {
////			audioFilePath = fileChooser.getSelectedFile().getAbsolutePath();
////			lastOpenPath = fileChooser.getSelectedFile().getParent();
////			
////		}
//	}
//}
