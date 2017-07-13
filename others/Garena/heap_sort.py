#!/usr/bin/python

def adjust(list, n, vt):
	while (vt <= n // 2 - 1):
		select = 2 * vt + 1
		if select + 1 < n and list[select + 1] > list[select]:
			select += 1
		if list[vt] < list[select]:
			swap(list, vt, select)
		vt = select

def swap(list, i, j):
	tmp = list[j]
	list[j] = list[i]
	list[i] = tmp

def heapSort(list):
	n = len(list)
	for i in xrange(n // 2 - 1, -1, -1):
		print i
		adjust(list, n, i)
	
	for i in xrange(n - 1, -1, -1):
		swap(list, 0, i);
		adjust(list, i, 0)

list = [28, 25, 15, 10, 9, 5, 1, 4, 8, 7]
heapSort(list)
print list