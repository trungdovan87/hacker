#!/usr/bin/python

class Node:
	def __init__(self, data, next = None):
		self.data = data
		self.next = next

	def __str__(self):
		s = "["
		it = self
		while (it is not None):
			if (it.next is None):
				s = s + str(it.data)
			else:
				s = s + str(it.data) + ", "
			it = it.next
		s = s + "]"
		return s

def convertLinkedList(list):
	head = Node(-1)
	last = head
	for i in list:
		last.next = Node(i)
		last = last.next
	return head.next

def merge(a1, a2):
	prev = None
	i1 = a1
	i2 = a2
	while (i1 is not None and i2 is not None):
		if (i1.data < i2.data):
			next1 = i1.next
			i1.next = prev
			prev = i1			
			i1 = next1
		else:
			next2 = i2.next
			i2.next = prev
			prev = i2			
			i2 = next2

	while (i1 is not None):	
		next1 = i1.next
		i1.next = prev
		prev = i1
		i1 = next1

	while (i2 is not None):	
		next2 = i2.next
		i2.next = prev
		prev = i2
		i2 = next2
	return prev

a1 = convertLinkedList([2, 3, 7, 8, 10, 12])
print "a1: ", a1

a2 = convertLinkedList([4, 5, 8])
print "a2: ", a2

print "----------"
print "merge: ", merge(a1, a2)