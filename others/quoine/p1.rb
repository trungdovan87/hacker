#!/usr/bin/ruby -w

=begin
cho mang 2 chieu, khong giam theo hang va cot
tim index cua 1 so	
=end
a = [
	[2, 3, 6, 25, 30],
	[3, 4, 7, 17, 37],
	[7, 8, 10, 19, 40],
	[8, 9, 15, 20, 47],
	[10, 11, 17, 27, 50]
]

# x always is in a
def findIndex(a, x)
	n = a.length
	i = n - 1
	j = 0
	while a[i][j] != x do
		if a[i][j + 1] <= x then
			j += 1
		else
			i -= 1
		end
	end
	return i, j
end

puts "find index:"
puts findIndex a, 37

#=====================================

# x may be not found in a
def findIndexMayNotFound(a, x)
	n = a.length
	m = a[0].length;
	i = n - 1;
	j = 0
	while (i >= 0)
		if a[i][j] == x
			return i, j
		end
		if j + 1 < m && a[i][j + 1] <= x then
			j += 1
		else
			i -= 1
		end
	end
	return false
end

puts "find index may not found:"
puts findIndexMayNotFound(a, 21)