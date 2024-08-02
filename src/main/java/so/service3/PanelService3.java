package so.service3;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionListener;

import io.grpc.stub.StreamObserver;
import so.service3.WhiteboardStreamGrpc;
import so.service3.WhiteboardUpdate;

public class PanelService3 
{

    private JTextField whiteboardTitleField, whiteboardReplyField; //Request and response text fields
    private JTextField contentTitleField, addContentField, contentReplyField;
    private JTextArea streamOutputArea;
    private JTextField streamWhiteboardNameField, streamContentField;
    private JButton startStreamButton;
    private JTextArea streamingUpdatesArea;
    private WhiteboardStreamGrpc.WhiteboardStreamStub streamStub;

    public JPanel createPanel(ActionListener listener) //Service 3 Panel
    {
        JPanel panel = new JPanel(); 
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        //Whiteboard Creation Panel
        JPanel whiteboardPanel = new JPanel();
        BoxLayout whiteboardLayout = new BoxLayout(whiteboardPanel, BoxLayout.X_AXIS);

        JLabel createLabel = new JLabel("Enter Whiteboard Title:"); //Labling to show user to input a whiteboard title
        whiteboardPanel.add(createLabel);
        whiteboardPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        whiteboardTitleField = new JTextField("", 10); //Text field to enter title
        whiteboardPanel.add(whiteboardTitleField);
        whiteboardPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton createButton = new JButton("Create Whiteboard"); //Button to create whiteboard
        createButton.setActionCommand("CREATE_WHITEBOARD");
        createButton.addActionListener(listener);  //Setting ActionListener
        whiteboardPanel.add(createButton);
        whiteboardPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        whiteboardReplyField = new JTextField("", 20); //Reply field to show the Whiteboard title when create
        whiteboardReplyField.setEditable(false); //Block editing capabilities of reply field
        whiteboardPanel.add(whiteboardReplyField);

        whiteboardPanel.setLayout(whiteboardLayout);

        // Content Addition Panel
        JPanel contentPanel = new JPanel();
        BoxLayout contentLayout = new BoxLayout(contentPanel, BoxLayout.X_AXIS);

        JLabel contentLabel = new JLabel("Enter Whiteboard Name:"); //Labling to show user to input a whiteboard title
        contentPanel.add(contentLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        contentTitleField = new JTextField("", 10); //Text field to enter title
        contentPanel.add(contentTitleField);
        contentPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JLabel addContentLabel = new JLabel("Enter Content:"); //Labling to show user to input whiteboard content
        contentPanel.add(addContentLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        addContentField = new JTextField("", 10);
        contentPanel.add(addContentField);
        contentPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton addContentButton = new JButton("Add Content"); //Button to add content to whiteboard
        addContentButton.setActionCommand("ADD_CONTENT");
        addContentButton.addActionListener(listener);  //Setting ActionListener
        contentPanel.add(addContentButton);
        contentPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        contentReplyField = new JTextField("", 20); //Reply field to show the Whiteboard name and content
        contentReplyField.setEditable(false); //Block editing capabilities of reply field
        contentPanel.add(contentReplyField);

        contentPanel.setLayout(contentLayout);

         //Streaming Panel
        JPanel streamPanel = new JPanel();
        BoxLayout streamLayout = new BoxLayout(streamPanel, BoxLayout.Y_AXIS);

        startStreamButton = new JButton("Start Streaming");
        startStreamButton.setActionCommand("START_STREAMING");
        startStreamButton.addActionListener(listener);
        streamPanel.add(startStreamButton);
        streamPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        //Initialize streamingUpdatesArea
        streamingUpdatesArea = new JTextArea(5, 10); //Adjust size as needed
        streamingUpdatesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(streamingUpdatesArea);
        streamPanel.add(scrollPane);

        streamPanel.setLayout(streamLayout);

        //Combining the Panels
        panel.add(whiteboardPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between panels
        panel.add(contentPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between panels
        panel.add(streamPanel);

        panel.setLayout(boxlayout);
        return panel;
    }

    //Get methods 
    public JTextField getWhiteboardTitle() 
    {
        return whiteboardTitleField;
    }

    public JTextField getWhiteboardReply() 
    {
        return whiteboardReplyField;
    }

    public JTextField getContentTitle() 
    {
        return contentTitleField;
    }

    public JTextField getAddContent() 
    {
        return addContentField;
    }

    public JTextField getContentReply() 
    {
        return contentReplyField;
    }

    public JTextArea getStreamOutputArea() 
    {
        return streamOutputArea;
    }

    public JTextField getStreamWhiteboardName() 
    {
        return streamWhiteboardNameField;
    }

    public JTextField getStreamContent() 
    {
        return streamContentField;
    }

    public JButton getStartStreamButton() 
    {
        return startStreamButton;
    }

    public void setStreamStub(WhiteboardStreamGrpc.WhiteboardStreamStub streamStub) 
    {
        this.streamStub = streamStub;
    }

    public JTextArea getStreamingUpdatesArea() 
    {
        return streamingUpdatesArea;
    }
}
