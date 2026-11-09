package ua.opnu.view;

import ua.opnu.model.DrawShape;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class DrawFrame extends JFrame {

    private PaintSurface surface;

    public DrawFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        surface = new PaintSurface();

        this.add(setButtonPanel(), BorderLayout.NORTH);
        this.add(surface, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    private JPanel setButtonPanel() {
        JPanel buttonPanel = new JPanel(true);

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.CYAN);
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));

        // 1. Кнопка для прямокутника
        BigTextButton rect = new BigTextButton("Rectangle");
        rect.addActionListener(e -> {
            surface.setShapeType(DrawShape.SHAPE_RECTANGLE);
        });
        buttonPanel.add(rect);

        // 2. Кнопка для закругленого прямокутника
        BigTextButton rounded_rect = new BigTextButton("Rounded rect.");
        rounded_rect.addActionListener(e -> {
            surface.setShapeType(DrawShape.SHAPE_ROUNDED_RECT);
        });
        buttonPanel.add(rounded_rect);

        // 3. Кнопка для еліпса
        BigTextButton ellipseBtn = new BigTextButton("Ellipse");
        ellipseBtn.addActionListener(e -> {
            surface.setShapeType(DrawShape.SHAPE_ELLIPSE);
        });
        buttonPanel.add(ellipseBtn);

        // 4. Кнопка "Clear" для очищення фігур
        BigTextButton clearBtn = new BigTextButton("Clear");
        clearBtn.addActionListener(e -> {
            surface.clearShapes();
        });
        buttonPanel.add(clearBtn);

        return buttonPanel;
    }
}