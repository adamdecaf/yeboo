# Yeboo Examples

## Grammer

    RepeatFactor := 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
    Color := r | g | b | w | x

    // r = red
    // g = green
    // b = blue
    // w = white
    // x = black

    Block := (RepeatFactor Color)
    Line := RepeatFactor Block*

## Sample

    2 (1g) (2b)

    Creates an image with the following pixels

    gbb
    gbb
