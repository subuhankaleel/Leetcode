/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    // If classFunction is not a valid function or constructor, it cannot have instances
    if (typeof classFunction !== 'function') {
        return false;
    }

    // Handle edge cases where obj is null or undefined (they have no prototype chain)
    if (obj === null || obj === undefined) {
        return false;
    }

    // Traverse up the prototype chain
    let currProto = Object.getPrototypeOf(obj);
    while (currProto !== null) {
        if (currProto === classFunction.prototype) {
            return true;
        }
        currProto = Object.getPrototypeOf(currProto);
    }

    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */
