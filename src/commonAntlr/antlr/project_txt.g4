grammar project_txt;


project: (entry | empty_line)+ EOF;

entry: (person_entry | task_entry );

person_entry: '+' NEWLINE;

empty_line: NEWLINE;

task_entry : task_state task_title task_options NEWLINE (task_notes? NEWLINE)?;

task_state : TASK_STATE_OPEN | TASK_STATE_DONE | TASK_STATE_MILESTONE;

task_options: (task_option | NEWLINE)*;
task_option: ( task_option_id | task_option_tag | task_option_label | task_option_dependency | task_option_assignment);

task_option_id: '#' WORD;
task_option_tag: '@' WORD;
task_option_label: '@' WORD ':' WORD;
task_option_dependency: '<' (task_option_tag | task_option_id );
task_option_assignment: '>' task_option_id;


task_title: WORD+?;

task_notes: (WORD | NEWLINE)*?;


/* Lexer */
WHITESPACE : (' ' | '\t') -> skip;
TASK_STATE_OPEN: '[ ]';
TASK_STATE_DONE: '[x]' | '[X]';
TASK_STATE_MILESTONE: '[m]' | '[M]';
WORD: [A-Za-z0-9_]+;
NEWLINE: '\r' | '\n' | '\r\n';

