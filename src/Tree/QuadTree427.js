/**
 * // Definition for a QuadTree node.
 * function _Node(val,isLeaf,topLeft,topRight,bottomLeft,bottomRight) {
 *    this.val = val;
 *    this.isLeaf = isLeaf;
 *    this.topLeft = topLeft;
 *    this.topRight = topRight;
 *    this.bottomLeft = bottomLeft;
 *    this.bottomRight = bottomRight;
 * };
 */

/**
 * @param {number[][]} grid
 * @return {_Node}
 */
function construct(grid) {

    return build(0, 0, grid.length);

    function build(x, y, size) {
        if (isUniform(x, y, size)) {
            return new Node(grid[x][y] === 1, true, null, null, null, null);
        }
        
        let half = size / 2;
        return new Node(
            false, 
            false,
            build(x, y, half),
            build(x, y + half, half),
            build(x + half, y, half),
            build(x + half, y + half, half)
        );
    }
    
    function isUniform(x, y, size) {
        const value = grid[x][y];
        for (let i = x; i < x + size; i++) {
            for (let j = y; j < y + size; j++) {
                if (grid[i][j] !== value) return false;
            }
        }
        return true;
    }
};