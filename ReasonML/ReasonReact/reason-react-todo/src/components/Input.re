let component = ReasonReact.statelessComponent("Input");

let make = (~value, ~onInputText, ~submit, _children) => {
    ...component,
    render: _self =>
        <div className="input">
            <input
                value
                placeholder="Insert an awesome item and click on add"
                onChange=(
                    event =>
                        onInputText(
                            ReactDOMRe.domElementToObj(ReactEventRe.Form.target(event))##value
                        )
                )
            />
            <button onClick=(_ => submit())> (ReasonReact.string("Add")) </button>
        </div>
};