#!/usr/bin/python

def quicksortUtils(list, l, r):
	if l >= r:
		return
	i = l
	j = r
	while (i <= j):
		pivot = list[(l + r) // 2]
		while (list[i] < pivot):
			i += 1
		while (list[j] > pivot):
			j -= 1
		if (i <= j):
			tmp = list[j]
			list[j] = list[i]
			list[i] = tmp
			i += 1
			j -= 1
		quicksortUtils(list, l, j)
		quicksortUtils(list, i, r)

def quicksort(list):
	quicksortUtils(list, 0, len(list) - 1)

list = [5,3,6,8,1,3,6]
quicksort(list)
print list
