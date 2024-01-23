package kuda.driverapi.prop

/**
 *
 * Conditional node types (CUgraphConditionalNodeType)
 *
 * @property IF Conditional 'if' Node. Body executed once if condition value is non-zero.
 * @property WHILE Conditional 'while' Node. Body executed repeatedly while condition value is non-zero.
 */
enum class GraphConditionalNodeType(val num : Int) {
    IF(0),
    WHILE(1)
}