package supply;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import com.sun.corba.se.impl.naming.namingutil.CorbanameURL;

@SuppressWarnings("serial")
public class SupplyMainFrame extends JFrame {

	private Dimension frameSize = new Dimension(1000, 800);
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Dimension frameLocation = new Dimension();

	private JSplitPane splitPane = null;
	private JScrollPane scrollPane = null;
	private JTree tree = null;
	private DefaultMutableTreeNode root = null;
	private DefaultMutableTreeNode[] brandNodes = null;
	private JTable table = null;

	private List<Brand> brands;

	public SupplyMainFrame(String title) throws HeadlessException {
		super(title);

		brands = new LinkedList<>(Car.allBrands.values());

		setPreferredSize(frameSize);
		frameLocation = setOnCenter(this, screenSize, frameSize);
		setLocation(frameLocation.width, frameLocation.height);

		root = new DefaultMutableTreeNode("Марки автомобилей");
		brandNodes = new DefaultMutableTreeNode[brands.size()];
		for (int i = 0; i < brandNodes.length; i++) {
			brandNodes[i] = new DefaultMutableTreeNode(brands.get(i));
			List<Model> models = new LinkedList<>(brands.get(i).getModels());
			if (models.size() > 0) {
				DefaultMutableTreeNode[] modelNodes = new DefaultMutableTreeNode[models.size()];
				for (int j = 0; j < modelNodes.length; j++) {
					modelNodes[j] = new DefaultMutableTreeNode(models.get(j));
					brandNodes[i].add(modelNodes[j]);
				}

			}
			root.add(brandNodes[i]);
		}
		tree = new JTree(root);
		tree.setRootVisible(true);
		//tree.setScrollsOnExpand(false);

		scrollPane = new JScrollPane(tree, 
									JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
									JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		// scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, new Corner());

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, table, scrollPane);
		// splitPane.setBounds(new Rectangle(100, 100, this.getWidth()-100,
		// this.getHeight()-100));
		splitPane.add(scrollPane);
		splitPane.setDividerLocation(0.5);
		//splitPane.setBounds(new Rectangle(100, 100, this.getWidth() - 100, this.getHeight() - 100));

		getContentPane().add(scrollPane);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}// constructor

	private Dimension setOnCenter(JFrame mainFrame2, Dimension screenSize2, Dimension frameSize2) {
		if (frameSize.getWidth() > screenSize.width) {
			frameSize.width = screenSize.width;
		}

		if (frameSize.getHeight() > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		return new Dimension((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

}
