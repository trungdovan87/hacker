#!/usr/bin/python


def swap(list, i, j):
	tmp = list[j]
	list[j] = list[i]
	list[i] = tmp	

def adjust(list, n, pos):
	while (pos <= n // 2 - 1):
		select = pos * 2 + 1
		if (select + 1 < n and list[select] < list[select + 1]):
			select += 1
		if (list[pos] < list[select]):			
			swap(list, pos, select)	
			pos = select		
		else:
			break
		

def heapSort(list):
	n = len(list)
	for i in xrange(n // 2 - 1, -1, -1):
		adjust(list, n, i)

	for i in xrange(n - 1, 0, -1):
		swap(list, 0, i)
		adjust(list, i, 0)

def searchFirstRe(x, list, l, r):
	if (l == r):
		if (list[l] == x):
			return l
		else:
			return -1
	if (l > r):
		return -1
	mid = (l + r) // 2
	if (x == list[mid]):
		return searchFirstRe(x, list, l, mid)
	elif (x < list[mid]):
		return searchFirstRe(x, list, l, mid - 1)
	else:
		return searchFirstRe(x, list, mid + 1, r)

def searchFirst(x, list):
	return  searchFirstRe(x, list, 0, len(list) - 1)


def searchLastRe(x, list, l, r):
	if (l == r):
		if (list[l] == x):
			return l
		else:
			return -1
	if (l > r):
		return -1
	if (l + 1 == r):
		if (list[r] == x):
			return r
		elif (list[l] == x):
			return l
		else:
			return -1

	mid = (l + r) // 2
	if (x == list[mid]):
		return searchLastRe(x, list, mid, r)
	elif (x < list[mid]):
		return searchLastRe(x, list, l, mid - 1)
	else:
		return searchLastRe(x, list, mid + 1, r)

def searchLast(x, list):
	return  searchLastRe(x, list, 0, len(list) - 1)

list = [2, 2, 2, 2]
print "first: ", searchFirst(3, list)
print "last: ", searchLast(1, list)
print list