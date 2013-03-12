# yeboo

## Usage

To use this it's as easy as.

    > run -O result.png design.yeb

With some file like

    adam@earth:~$ cat design.yeb
    1 (1g) (2b)
    2 (2w)

## Cleanup

* Refine the parser to create more structures and representations of the language
* Implement ways that will allow for the expansion of the language.

## TODO

* Introduce CLI args parsing (from) library
* Add more colors (java.awt.Color)
* Clean up code.
* Handle Multiple input/output files?
* Create larger example images
* Preprocessing layer before FileParser to create lines, circles, etc..
* Patern syntax [(2g) (4b)]{4} for "(2g) (4b) (2g) (4b) (2g) (4b) (2g) (4b)"
* Introduce the cli-args project.
* {4 g b c} == [(1g) (1b) (1c)]{4}
