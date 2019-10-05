let component = ReasonReact.statelessComponent("Item");
    let make = (~item: TodoType.item, ~onRemove, ~onToggle, _children) => {
    ...component,
    render: _self =>
        <div className="item">
            <input
                type_="checkbox"
                checked=item.completed
                onChange=(_ => onToggle(item.id))
            />
            <p className={item.completed ? "markAsDone" : ""}> {ReasonReact.string(item.title)} </p>
            <button onClick=(_ => onRemove(item.id))>
                {ReasonReact.string("Remove")}
            </button>
        </div>
    };