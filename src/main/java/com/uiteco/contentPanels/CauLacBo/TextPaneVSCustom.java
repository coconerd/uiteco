
package com.uiteco.contentPanels.CauLacBo;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
    *
    * @author 21H1 HNQA
    */
public class TextPaneVSCustom extends JTextPane {
    private ArrayList<TextStyle> ListText = new ArrayList();
    
    SimpleAttributeSet normal = new SimpleAttributeSet();
    SimpleAttributeSet title = new SimpleAttributeSet();
    SimpleAttributeSet indent = new SimpleAttributeSet();
    SimpleAttributeSet indentLevel1 = new SimpleAttributeSet();
    SimpleAttributeSet indentLevel3 = new SimpleAttributeSet();
    SimpleAttributeSet italicType1 = new SimpleAttributeSet();
    SimpleAttributeSet italicType2 = new SimpleAttributeSet();
    
    Document doc = null;
    
    public TextPaneVSCustom()
    {
        Start();   
    }
    
    private void InitAttribute()
    {
        int size = this.getStyledDocument().getFont(title).getSize();
        
        StyleConstants.setBold(title, true);
        StyleConstants.setFontSize(title, size + 15);
//        System.out.println("size: " + this.getStyledDocument().getFont(title).getSize());        
        StyleConstants.setItalic(italicType1, true);
        
        StyleConstants.setItalic(italicType2, true);
        StyleConstants.setBold(italicType2, true);
        StyleConstants.setFontSize(italicType2, size + 10);
        
        StyleConstants.setBold(indent, true);
        StyleConstants.setFontSize(indent, size + 2);
    }
    
    @Override
    public void setText(String t) {
        super.setText("");
        
        doc = this.getStyledDocument();
        
        this.setCharacterAttributes(title, true);
        
        // "#" title
        // "** **" italicType1
        // "** **" italicType2
        // "\n -" indentLevel1
        // "\n  -" indentLevel2
        // "\n   -" indentLevel3
        // none normal
        
        t += "      ";
        
//        super.setText(t);
        
        SimpleAttributeSet curAttribute = normal;
   
        for (int i = 0; i < t.length(); i++)
        {
            String temp = "";
            
            if(t.charAt(i) == '#')
            {
                curAttribute = title;
                continue;
            }
            else 
            if(t.charAt(i) == '*' && t.charAt(i + 1) == '*')
            {
                if(curAttribute == italicType1)
                    curAttribute = normal;
                else if(curAttribute == italicType2)
                    curAttribute = title;
                else if(curAttribute == title)
                    curAttribute = italicType2;
                else
                    curAttribute = italicType1;
                
                i += 1;
                continue;
            }
            else
            if(t.charAt(i) == '\n')   
            {
                curAttribute = normal;
                if(t.charAt(i + 1) == ' ' && t.charAt(i + 2) == '-')
                {
                    temp = "\n  •";
                    i += 3;  
                }
                if(t.charAt(i + 1) == ' ' && t.charAt(i + 2) == ' ' && t.charAt(i + 3) == '-')
                {
                    temp = "\n    ◦";
                    i += 4;
                }
                if(t.charAt(i) == '\n' && t.charAt(i + 1) == ' ' && t.charAt(i + 2) == ' ' && t.charAt(i + 3) == ' ' && t.charAt(i + 4) == '-')
                {
                    temp = "\n      ‣";
                    i += 5;
                }
                
                try {
                    doc.insertString(doc.getLength(), temp , indent);
                } catch (BadLocationException ex) {
                    
                }
            }
                
            if(i == t.length() - 6)
                break;

            if(curAttribute == title)
                print("title: " + t.charAt(i));
            else if(curAttribute == italicType1)
                print("italicType1: " + t.charAt(i));
            else if(curAttribute == italicType2)
                print("italicType2: " + t.charAt(i));
            else
                print("normal: " + t.charAt(i));
            
            try {
                doc.insertString(doc.getLength(), "" + t.charAt(i), curAttribute);
            } catch (BadLocationException ex) {
                
            }
        }
        
        this.setCharacterAttributes(title, false);
        this.setCharacterAttributes(normal, true);
    }
   
    private void Start()
    {
        InitAttribute();
    }
    
    private void print(String c)
    {
        System.out.println(c);
    }
    private void print(char c)
    {
        System.out.println(c);
    }
}

class TextStyle
{
    public String text;
    public int style;
    
    public TextStyle()
    {}
    
    public TextStyle(String text, int style)
    {
        this.text = text;
        this.style = style;
    }
    
    public String getText()
    {
        return text;
    }
    
    public int getStyle()
    {
        return style;
    }
}
