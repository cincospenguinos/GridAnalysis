# Grid Analyzer

This is a simple Java application (*very* simple java application) that explores a small puzzle or game I always played
when I was a kid. The rules of this game are as follows:

* Imagine you have a grid of n by m, given n and m are positive integers
* Beginning in the top left corner of the grid, move diagonally from point to point
* If you reach the edge of the grid, move in the opposite direction of that edge (so move left when you reach the right
edge, or move up when you reach the bottom edge, etc.)
* Continue moving in this way until you reach a corner of the grid

I would play this game in my spare time in my mind while looking at grid-styled walls and floors. I always wondered what
the various properties of each grid was and how they relate to other grids that I could come up with. If you always
begin in the top left corner, which types of grids have paths that terminate in the opposite corner, or one of the
other two corners? Is there any grid that terminates in the same corner it started? What properties of that grid cause
it to be so?

So I started tinkering around with things and made this simple program to explore what those grids look like and see
how they may relate to each other. I have a few hypotheses concerning these grids:

1. The path of any n by m grid is congruent to another l by h grid where l = kn and h = km, where k is a positive integer
2. Given that hypothesis 1 is true, the only unique grids are those where n and m are co-prime. All paths of any grid l by h
are completely congruent and therefore can be reduced to the grid n by m, given l = kn and h = km and k is a positive integer.
3. The n by n grid
    * Always has perfectly symmetric paths (that is, the path starting in the top left corner will be symmetric horizontally
    and vertically to the path starting on the bottom left corner of the grid)
    * All paths in this grid end in the opposite corner they start (see hypothesis 5)
4. Grids of n by n + 1
    * The path originating in the top left corner of the grid terminates on the top right corner when n is even
    * The path originating in the top left corner of the grid terminates on the bottom left corner when n is odd
5. Grids of n by 2k + 1 always have paths that terminate in the bottom right corner, given the path starts in the top left
corner and k is a natural number.
6. The path in the n by m grid is a simple transformation of the path in the m by n grid.

Feel free to copy this source code and use it how you would like. If anyone else has puzzled around with this and has made
any proofs for any of these things, I would really like to know. It's been fun revisiting a part of my childhood and
exploring the nuances of this puzzle.