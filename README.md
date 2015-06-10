# yeboo

> A toy language for creating images.

## Introduction

Images are represented as the following

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

- The only type is a long
- &name means a function which takes one param, the current pixels over from the left (where x = 0).

```
red_block(width, height, &fill, border = 3) = {
    (width red)
    (border black) (width - border
}
```
