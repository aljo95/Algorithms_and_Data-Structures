/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {

  let mid = Math.floor((nums.length)/2);
  
  if (nums[mid] == target) return mid;
  if (mid <= 1 || nums.length == 1) return 1;

  if (nums[mid] > target) return mid - searchInsert(nums.slice(0, mid), target);
  else if (nums[mid] < target) return mid + searchInsert(nums.slice(mid), target);
		// 1: return 2 + f([5,6], 7)
		// 2: return 2 + 1 + shit
};

console.log(searchInsert([1, 3, 5, 6], 5)); 		// Return 2
console.log(searchInsert([1, 3, 5, 6], 2)); 		// Return 1
console.log(searchInsert([1, 3, 5, 6], 7)); 		// Return 4
console.log(searchInsert([1, 3, 5, 6, 8], 7)); 		// Return 4
