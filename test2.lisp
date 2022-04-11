(setq A 29)
(setq B (+ A 13))
B
A
((lambda () 42))
((lambda (X) 42) 2)
((lambda (X Y) 42) 2 3)
((lambda (X Y Z) 42) 2 3 4)
(setq listDerivedSafe 
	(lambda (X Y Z) (or 
		(and (>= X 13) (<= Y 30) (<= Z 30))
		(and (>= X 6) (<= Y 30) (<= Z 10))
		(and (>= X 27) (<= Y 30) (<= Z 50))
		(and (>= X 13) (<= Y 15) (<= Z 50))
		(and (>= X 13) (<= Y 120) (<= Z 10))
		(and (>= X 27) (<= Y 120) (<= Z 30))
		(and (>= X 6) (<= Y 15) (<= Z 30))
		)
	)
)
(setq x 5)
(setq timesGenerator	
     (lambda (x)
  	(function 
                (lambda (y) (* x y))
            )
    )
)
(setq twice (funcall timesGenerator 2))
(setq isList (lambda (X) (cond
							 
							((and (not (atom X)) (not (cdr X))) t)
							((not (atom X)) (funcall isList (cdr X)))
							(t nil)
						  )))
(funcall isList NIL)	
(funcall isList (cons 5 (cons 2 nil)))		
(funcall isList (cons 5 2))
			  
			  
