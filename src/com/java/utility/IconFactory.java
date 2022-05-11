package com.java.utility;

import com.java.data.ImagesEnum;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class IconFactory {

  public static Image getImage(ImagesEnum imagesEnum) {
    Image image = new Image(imagesEnum.getPath());

    return image;
  }

  public enum ImageTransformAction {
    NONE,
    COLOR_WHITE(255, 255, 255),
    COLOR_ICON(51, 51, 51),
    COLOR_CREATE(246, 146, 30),
    COLOR_READ(0, 113, 187),
    COLOR_UPDATE(0, 148, 69), //to match Admin State Up icon, original: 0, 145, 60
    COLOR_DELETE(192, 39, 45),
    COLOR_BUTTON(0, 0, 0),
    COLOR_YELLOW(255, 255, 0),
    COLOR_ICON_WEB(117, 117, 117);

    private final boolean transform;
    final int r;
    final int g;
    final int b;

    ImageTransformAction() {
      this.transform = false;
      r = 0;
      g = 0;
      b = 0;
    }

    ImageTransformAction(int r, int g, int b) {
      this.transform = true;
      this.r = r;
      this.g = g;
      this.b = b;
    }

    public ImageView transform(ImageView imageView) {
      if (!transform || imageView == null)
        return imageView;
      javafx.scene.image.Image src = imageView.getImage();
      if (src == null) {
        return imageView;
      }
      PixelReader reader = src.getPixelReader();

      int width = (int) src.getWidth();
      int height = (int) src.getHeight();

      WritableImage dest = new WritableImage(width, height);
      PixelWriter writer = dest.getPixelWriter();

      for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
          writer.setColor(x, y, javafx.scene.paint.Color.rgb(r, g, b, reader.getColor(x, y).getOpacity()));
        }
      }

      imageView.setImage(dest);
      return imageView;
    }
  }
}