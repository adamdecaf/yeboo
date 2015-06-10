# yeboo

> A toy language for creating images.

## Introduction

Images are represented as the following coordinate grid. Each pixel (also known as an (x,y) pair) has a color. That color is the value at `p(x,y)`.

       0                                   x
       ------------------------------------
    0 |
      |
      |              .
      |            p(x,y)
      |
      |
      |
    y |

## Example

__Before you start__

- There are two types: `color` (defined as `$name`) and `long` (defined as `name`)
- `&name` means a function which takes one param, the current pixels over from the left (where x = 0).

```
// Defined in stdlib
line($fill_color, height, width) = {
    // For `height` rows, make pixels colored `$fill_color` and `width` many along the x-axis
    height * (width $fill_color)
}

solid_block(height, width, &contents) = {
    height * (width &contents)
}

vborder($fill_color, border_width, overall_width, &contents) = {
    // Make a verticle border colored `$fill_color` that is `overall_width` wide with `border_width` padding on the edges,
    // then fill it with `&contents` at each pixel in between.
    // This generates something like the following
    //
    //  border          &contents        border
    // |||||||||    ---------------    |||||||||
    //
    (border_width $fill_color) (overall_width - (2 * border_width) &contents) (border_width $fill_color)
}

black_vborder(border_width, overall_width, &contents) = vborder(BLACK, border_width, overall_width, &contents)

// Fancy functions
alternate_even_odd($even, $odd, p) = {
  if (p % 2 == 0) {
    even
  } else {
    odd
  }
}

// Application code
red_block(height, width) = solid_block(height, width, alternate_even_odd(RED, BLACK, _))
```
